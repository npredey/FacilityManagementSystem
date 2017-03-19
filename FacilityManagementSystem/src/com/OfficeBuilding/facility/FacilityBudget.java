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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.savings) ^ (Double.doubleToLongBits(this.savings) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.operatingBudget) ^ (Double.doubleToLongBits(this.operatingBudget) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FacilityBudget other = (FacilityBudget) obj;
        if (Double.doubleToLongBits(this.savings) != Double.doubleToLongBits(other.savings)) {
            return false;
        }
        if (Double.doubleToLongBits(this.operatingBudget) != Double.doubleToLongBits(other.operatingBudget)) {
            return false;
        }
        return true;
    }

}
