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

        // sort states with the specific limit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the VAT limit to sort the sates: (Default is 20)");
        String input = scanner.nextLine();
        states.sortStatesWithLimit(input);

        // print states with VAT over "input" and not using the special tax
        System.out.println("All states with VAT over " + input + "% and not using special tax: ");
        states.getStatesOverLimit().forEach(System.out::println);
        System.out.println("_____\n");

        // sort the states above by VAT, descends
        System.out.println("States above sorted by VAT, descends:");
        ArrayList<State> statesSorted = states.getStatesOverLimit();
        statesSorted.sort(Comparator.comparing(State::getRegularTax).reversed());
        statesSorted.forEach(System.out::println);
        System.out.println("====================");

        // states with VAT 20% and lower or states using special tax
        System.out.print("States with VAT " + input + "% or lower or using special tax: ");
        states.getStatesBelowLimit().forEach(item -> System.out.print(item.getStateID()+", "));

        // print list of states with VAT over "input" into txt
        try{states.writeToTxt(Settings.getFilenameOut(),Settings.getDelimetr());}
        catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }
    }
}
