package com.engeto.vat;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StatesDataSet {
    private final ArrayList<State> states = new ArrayList<>();
    private final ArrayList<State> statesOverLimit = new ArrayList<>();
    private final ArrayList<State> statesBelowLimit = new ArrayList<>();

    //region Getters
    public ArrayList<State> getStates(){
        return new ArrayList<>(states);
    }

    public ArrayList<State> getStatesOverLimit() {
        return statesOverLimit;
    }

    public ArrayList<State> getStatesBelowLimit() {
        return statesBelowLimit;
    }
    //endregion

    //region Read and write from / to files
    public void readFromCsv(String filename, String delimetr) throws StateException {
        String line;
        int lineNumber = 0;
        String lineCorrected;
        String[] items;

        try (Scanner scanner = new Scanner(new File(filename))){

            while (scanner.hasNextLine()){
                lineNumber++;
                line = scanner.nextLine();
                lineCorrected = line.replace(",",".");
                items = lineCorrected.split(delimetr);
                states.add(new State(items[0],
                        items[1],
                        Double.parseDouble(items[2]),
                        Double.parseDouble(items[3]),
                        Boolean.parseBoolean(items[4])));
            }
        } catch (FileNotFoundException e){
            throw new StateException("File "+ filename +"was not found.\n" + e.getLocalizedMessage());
        } catch (NumberFormatException e){
            throw  new StateException("There is a wrong number format. Please check this row: "
            + lineNumber + " in file: " + filename +"\n"+e.getLocalizedMessage());
        }
    }
    public void writeToTxt(String filename, String delimetr) throws StateException {
        ArrayList<State> list = getStatesOverLimit();
        ArrayList<String> rows = new ArrayList<>();

        for (State state : list){
            rows.add(state.getStateID()
                    +delimetr+state.getStateName()
                    +delimetr+state.getRegularTax()
                    +delimetr+state.getReducedTax()
                    +delimetr+state.hasSpecialTax());
        }

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(String row : rows){writer.println(row);}
        } catch (IOException e){
            throw new StateException("There is a problem with file" + e.getLocalizedMessage());
        }
    }
    //endregion

    public void sortStatesWithLimit(int limit){

        for (State state : states){
            if (state.getRegularTax() > limit && ! state.hasSpecialTax()){
                statesOverLimit.add(state);
            } else {
                statesBelowLimit.add(state);
            }
        }
    }
}