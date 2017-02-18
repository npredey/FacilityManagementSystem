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
public class MaintenanceSchedule {

    private Date timeOfMaintenance;

    public MaintenanceSchedule(String timeOfMaintenance) {
        this.timeOfMaintenance = new Date(timeOfMaintenance);
    }

    public void setTimeOfMaintenance(Date value) {
        timeOfMaintenance = value;
    }

    public Date getTimeOfMaintenance() {
        return timeOfMaintenance;
    }
}
