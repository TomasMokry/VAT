package com.engeto.vat;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StateDataSet {
    private ArrayList<State> states = new ArrayList<>();

    public ArrayList<State> getStates(){
        return new ArrayList<State>(states);
    }

    public void readFromCsv(String filename, String delimetr) throws StateException {
        try (Scanner scanner = new Scanner(new File(filename))){
            String line;
            String lineCorrected;
            String[] items;

            while (scanner.hasNextLine()){
                line = scanner.nextLine();
                lineCorrected = line.replace(",",".");
                items = lineCorrected.split("\t");
                states.add(new State(items[0],
                        items[1],
                        Double.parseDouble(items[2]),
                        Double.parseDouble(items[3]),
                        Boolean.parseBoolean(items[4])));
            }
        } catch (FileNotFoundException e){
            throw new StateException("File "+ filename +"was not found.\n" + e.getLocalizedMessage());
        }
    }
    public void writeToTxtStatesVatOver20(String filename, String delimetr) throws StateException {
        ArrayList<State> list = getStatesWithTaxOver20();
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

    public void filterAndPrintToTxt(String delimetr,int limit) throws StateException {

        ArrayList<State> list = new ArrayList<>();
        for (State state : states){
            if (state.getRegularTax()> limit && !state.hasSpecialTax()){
                list.add(state);}
        }

        ArrayList<String> rows = new ArrayList<>();

        for (State state : list){
            rows.add(state.getStateID()
                    +delimetr+state.getStateName()
                    +delimetr+state.getRegularTax()
                    +delimetr+state.getReducedTax()
                    +delimetr+state.hasSpecialTax());

        }
        String filename = "vat-over-";
        filename = filename+limit+".txt";

        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))){
            for(String row : rows){writer.println(row);}

        } catch (Exception e){
            throw new StateException("There is a problem with file" + e.getLocalizedMessage());
        }
    }

    public ArrayList<State> getStatesWithTaxOver20(){
        ArrayList<State> statesWithTaxOver20 = new ArrayList<>();
        for (State state : states){
            if (state.getRegularTax()>20 && !state.hasSpecialTax()){
                statesWithTaxOver20.add(state);}
        }
        return statesWithTaxOver20;
    }

}
