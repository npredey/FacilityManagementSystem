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
public class MaintenanceRequest {

    private int maintenancePeriod;
    private String maintenanceRequester;
    private String problem;

    public MaintenanceRequest(int maintenancePeriod, String maintenanceRequester,
            String problem) {
        this.maintenancePeriod = maintenancePeriod;
        this.maintenanceRequester = maintenanceRequester;
        this.problem = problem;
    }

    public void setMaintenancePeriod(int value) {
        maintenancePeriod = value;
    }

    public void setMaintenanceRequester(String value) {
        maintenanceRequester = value;
    }

    public void setProblem(String value) {
        problem = value;
    }

    public int getMaintenancePeriod() {
        return maintenancePeriod;
    }

    public String getMaintenanceRequester() {
        return maintenanceRequester;
    }

    public String getProblem() {
        return problem;
    }
}
