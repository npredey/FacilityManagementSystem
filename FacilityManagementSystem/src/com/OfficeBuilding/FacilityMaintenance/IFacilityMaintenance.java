/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

import java.util.List;

/**
 *
 * @author nickpredey
 */
public interface IFacilityMaintenance {

    void addMaintenanceRequest(MaintenanceRequest request);

    void createMaintenanceSchedule();

    int getMaintenanceCost();

    MaintenanceRequest getMaintenanceRequest();

    List<String> getFacilityProblems(); //pass in a request object

    double calcFacilityProblemRate();

    int getFacilityDownTime();

    void scheduleRequest(MaintenanceSchedule ms);

    MaintenanceLog getLog();

    List<MaintenanceRequest> getRequestQueue();

    String listMaintenance();

    String listMaintenanceRequests();

    String listFacilityProblems();
}
