/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

/**
 *
 * @author nickpredey
 */
public class FacilityBudget {

    private double savings;
    private double operatingBudget;

    public FacilityBudget(double savings, double operatingBudget) {
        this.savings = savings;
        this.operatingBudget = operatingBudget;
    }

    public void setOperatingBudget(double value) {
        operatingBudget = value;
    }

    public void setSavings(double value) {
        savings = value;
    }

    public double getOperatingBudget() {
        return operatingBudget;
    }

    public double getSavings() {
        return savings;
    }

    @Override
    public String toString() {
        return "FacilityBudget{" + "savings=" + savings + ", operatingBudget=" + operatingBudget + '}';
    }

}
