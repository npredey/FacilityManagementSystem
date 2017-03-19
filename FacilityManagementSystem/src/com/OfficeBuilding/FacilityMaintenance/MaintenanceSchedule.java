/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

import java.util.Date;

/**
 *
 * @author nickpredey
 */
public class MaintenanceSchedule implements IMaintenanceSchedule {

    private int timeOfMaintenance;

    private IMaintenanceRequest request;

    public MaintenanceSchedule() {
//        this.timeOfMaintenance = timeOfMaintenance;
//        this.request = request;
    }

    @Override
    public IMaintenanceRequest getRequest() {
        return request;
    }

    @Override
    public void setRequest(IMaintenanceRequest request) {
        this.request = request;
    }

    /**
     * Sets the time that this maintenance is scheduled.
     *
     * @param value
     */
    @Override
    public void setTimeOfMaintenance(int value) {
        timeOfMaintenance = value;
    }

    /**
     * Gets the time that this maintenance is scheduled.
     *
     * @return
     */
    @Override
    public int getTimeOfMaintenance() {
        return timeOfMaintenance;
    }
}
