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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.maintenancePeriod;
        hash = 47 * hash + Objects.hashCode(this.maintenanceRequester);
        hash = 47 * hash + Objects.hashCode(this.problem);
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
        final MaintenanceRequest other = (MaintenanceRequest) obj;
        if (this.maintenancePeriod != other.maintenancePeriod) {
            return false;
        }
        if (!Objects.equals(this.maintenanceRequester, other.maintenanceRequester)) {
            return false;
        }
        if (!Objects.equals(this.problem, other.problem)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" + "maintenancePeriod=" + maintenancePeriod + ", maintenanceRequester=" + maintenanceRequester + ", problem=" + problem + '}';
    }

}
