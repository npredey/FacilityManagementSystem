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

    private Date timeOfMaintenance;

    private MaintenanceRequest request;

    public MaintenanceSchedule(int timeOfMaintenance, MaintenanceRequest request) {
        this.timeOfMaintenance = new Date(timeOfMaintenance);
        this.request = request;
    }

    /**
     * Sets the time that this maintenance is scheduled.
     *
     * @param value
     */
    @Override
    public void setTimeOfMaintenance(Date value) {
        timeOfMaintenance = value;
    }

    /**
     * Gets the time that this maintenance is scheduled.
     *
     * @return
     */
    @Override
    public Date getTimeOfMaintenance() {
        return timeOfMaintenance;
    }
}
