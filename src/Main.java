import com.engeto.vat.Settings;
import com.engeto.vat.State;
import com.engeto.vat.StateException;
import com.engeto.vat.StatesDataSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StatesDataSet states = new StatesDataSet();

        // reading from csv file all states
        try{
            states.readFromCsv(Settings.getFilenameIn(),Settings.getDelimetr());
        } catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }
        // print full list of states
        System.out.println("All states: ");
        states.getStates().forEach(System.out::println);
        System.out.println("_____\n");

        // print states with VAT over 20% and not using the special tax
        System.out.println("All states with VAT over 20% and not using special tax: ");
        states.getStatesWithVatOver20().forEach(System.out::println);
        System.out.println("_____\n");

        // sort the states above by VAT, descends
        System.out.println("States above sorted by VAT, descends:");
        ArrayList<State> statesSorted = states.getStatesWithVatOver20();
        statesSorted.sort(Comparator.comparing(State::getRegularTax).reversed());
        statesSorted.forEach(System.out::println);
        System.out.println("====================");

        // states with VAT 20% and lower or states using special tax
        System.out.print("States with VAT 20% or lower or using special tax: ");
        for (State state : states.getStates()){
            if(state.getRegularTax()<= 20 || state.hasSpecialTax()){
                System.out.print(state.getStateID()+", ");
            }
        }

        // print list of states with VAT over 20 into txt
        try{states.writeToTxtStatesVatOver20(Settings.getFilenameOut(),Settings.getDelimetr());}
        catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }

        // take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the limit for the VAT to filter states: ");
        String input = scanner.nextLine();
        try{states.filterAndPrintToTxt(Settings.getDelimetr(),input);}
        catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }






    }
}