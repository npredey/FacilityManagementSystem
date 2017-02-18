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

    void addMaintenanceRequest(MaintenanceRequest request);

    void createMaintenanceSchedule();

    void getMaintenanceCost();

    MaintenanceRequest getMaintenanceRequest();

    List<String> getFacilityProblems(); //pass in a request object

    double calcFacilityProblemRate();

    void getFacillityDownTime();

    void scheduleRequest(MaintenanceSchedule ms);
}
