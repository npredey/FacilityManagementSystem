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
public class FacilityBudget implements IFacilityBudget {

    private double savings;
    private double operatingBudget;

    public FacilityBudget() {
//        this.savings = savings;
//        this.operatingBudget = operatingBudget;
    }

    @Override
    public void setOperatingBudget(double value) {
        operatingBudget = value;
    }

    @Override
    public void setSavings(double value) {
        savings = value;
    }

    @Override
    public double getOperatingBudget() {
        return operatingBudget;
    }

    @Override
    public double getSavings() {
        return savings;
    }

    @Override
    public String toString() {
        return "FacilityBudget{" + "savings=" + savings + ", operatingBudget=" + operatingBudget + '}';
    }

}
