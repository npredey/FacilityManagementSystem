package com.OfficeBuilding.FacilityMaintenance;

/**
 * @author nathnael2
 */
public class MaintenanceCost implements IMaintenanceCost {

    private double dollarAmount;

    public MaintenanceCost() {
        //this.dollarAmount = dollarAmount;
    }

    /**
     * Gets the dollar amount of a particular maintenance cost.
     *
     * @return
     */
    @Override
    public double getDollarAmount() {
        return dollarAmount;
    }

    /**
     * Sets the cost of a particular maintenance cost.
     *
     * @param dollarAmount
     */
    @Override
    public void setDollarAmount(double dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (int) (Double.doubleToLongBits(this.dollarAmount) ^ (Double.doubleToLongBits(this.dollarAmount) >>> 32));
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
        final MaintenanceCost other = (MaintenanceCost) obj;
        if (Double.doubleToLongBits(this.dollarAmount) != Double.doubleToLongBits(other.dollarAmount)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceCost{" + "dollarAmount=" + dollarAmount + '}';
    }

}
