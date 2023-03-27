package com.engeto.vat;

public class Settings {
    private static final String FILENAME_IN = "vat-eu.csv";
    private static final String FILENAME_OUT = "vat-over-20.txt";
    private static final String DELIMETR = "\t";

    public static String getFilenameIn(){
        return FILENAME_IN;
    }

    public static String getFilenameOut(){
        return FILENAME_OUT;
    }

    public static String getDelimetr(){
        return DELIMETR;
    }


}
