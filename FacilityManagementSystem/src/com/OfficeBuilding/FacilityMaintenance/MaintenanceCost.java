package com.OfficeBuilding.FacilityMaintenance;

/**
 * @author nathnael2
 */
public class MaintenanceCost implements IMaintenanceCost {

    private double dollarAmount;

    public MaintenanceCost(double dollarAmount) {
        this.dollarAmount = dollarAmount;
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

}
