/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.timeOfMaintenance;
        hash = 13 * hash + Objects.hashCode(this.request);
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
        final MaintenanceSchedule other = (MaintenanceSchedule) obj;
        if (this.timeOfMaintenance != other.timeOfMaintenance) {
            return false;
        }
        if (!Objects.equals(this.request, other.request)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceSchedule{" + "timeOfMaintenance=" + timeOfMaintenance + ", request=" + request + '}';
    }

}
