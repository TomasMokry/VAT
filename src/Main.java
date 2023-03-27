import com.engeto.vat.Settings;
import com.engeto.vat.State;
import com.engeto.vat.StateException;
import com.engeto.vat.StatesDataSet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        StatesDataSet states = new StatesDataSet();
        try{
            states.readFromCsv(Settings.getFilenameIn(),Settings.getDelimetr());
        }catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }

        states.getStates().forEach(System.out::println);
        System.out.println("***************************");

        states.getStatesWithTaxOver20().forEach(System.out::println);
        System.out.println("***************************");
        ArrayList<State> statesSorted = states.getStatesWithTaxOver20();
        statesSorted.sort(Comparator.comparing(State::getRegularTax).reversed());
        statesSorted.forEach(System.out::println);
        System.out.println("***************************");
        //Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: AT, CY, CZ
        System.out.print("Sazba VAT 20 % nebo nižší nebo používají speciální sazbu: ");
        for (State state : states.getStates()){
            if(state.getRegularTax()<=20 && state.hasSpecialTax()){
                System.out.print(state.getStateID()+", ");
            }
        }
        try{states.writeToTxtStatesVatOver20(Settings.getFilenameOut(),Settings.getDelimetr());}
        catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter the limit for the VAT to filter states: ");
        String input = scanner.nextLine();
        try{states.filterAndPrintToTxt(Settings.getDelimetr(),Integer.parseInt(input));}
        catch (StateException e){
            System.err.println(e.getLocalizedMessage());
        }






    }
}