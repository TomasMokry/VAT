package com.engeto.vat;

public class State {
    private String stateID;
    private String stateName;
    private double regularTax;
    private double reducedTax;
    private boolean hasSpecialTax;

    public State(String stateID, String stateName, double regularTax, double reducedTax, boolean hasSpecialTax) {
        this.stateID = stateID;
        this.stateName = stateName;
        this.regularTax = regularTax;
        this.reducedTax = reducedTax;
        this.hasSpecialTax = hasSpecialTax;
    }

    public String getStateID() {
        return stateID;
    }

    public void setStateID(String stateID) {
        this.stateID = stateID;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public double getRegularTax() {
        return regularTax;
    }

    public void setRegularTax(double regularTax) {
        this.regularTax = regularTax;
    }

    public double getReducedTax() {
        return reducedTax;
    }

    public void setReducedTax(double reducedTax) {
        this.reducedTax = reducedTax;
    }

    public boolean hasSpecialTax() {
        return hasSpecialTax;
    }

    public void setHasSpecialTax(boolean hasSpecialTax) {
        this.hasSpecialTax = hasSpecialTax;
    }

    @Override
    public String toString() {
        return this.stateName
                + " ("
                + this.stateID
                + "): "
                + this.regularTax
                + " %";
    }
}
