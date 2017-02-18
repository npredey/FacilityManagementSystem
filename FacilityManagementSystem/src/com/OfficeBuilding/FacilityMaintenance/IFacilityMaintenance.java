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
public interface IFacilityMaintenance {

    public void addMaintenanceRequest();

    public void createMaintenanceSchedule();

    public void getMaintenanceCost();

    public void getMaintenanceRequests();

    public void getFacilityProblems(); //pass in a request object

    public void calcFacilityProblemRate();

    public void getFacillityDownTime();
}
