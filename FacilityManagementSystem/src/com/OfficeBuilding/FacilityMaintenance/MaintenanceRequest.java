/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

/**
 *
 * @author nickpredey
 */
public class MaintenanceRequest implements IMaintenanceRequest {

    private int maintenancePeriod;
    private String maintenanceRequester;
    private String problem;

    public MaintenanceRequest() {
//        this.maintenancePeriod = maintenancePeriod;
//        this.maintenanceRequester = maintenanceRequester;
//        this.problem = problem;
    }

    /**
     * Sets the amount of time a maintenance request will take.
     *
     * @param value
     */
    @Override
    public void setMaintenancePeriod(int value) {
        maintenancePeriod = value;
    }

    /**
     * This sets the name of the person who made the maintenance request.
     *
     * @param value
     */
    @Override
    public void setMaintenanceRequester(String value) {
        maintenanceRequester = value;
    }

    /**
     * Sets the current problem of this maintenance request, i.e. "Sprinklers in
     * the break room are broken".
     *
     * @param value
     */
    @Override
    public void setProblem(String value) {
        problem = value;
    }

    /**
     * Gets the current, expected time period of this maintenance request
     * object.
     *
     * @return
     */
    @Override
    public int getMaintenancePeriod() {
        return maintenancePeriod;
    }

    /**
     * Returns the name of the person who made the maintenance request.
     *
     * @return
     */
    @Override
    public String getMaintenanceRequester() {
        return maintenanceRequester;
    }

    /**
     * Returns the problem of this maintenance request.
     *
     * @return
     */
    @Override
    public String getProblem() {
        return problem;
    }

}
