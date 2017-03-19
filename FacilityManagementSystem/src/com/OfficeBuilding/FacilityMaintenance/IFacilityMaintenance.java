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

    void addMaintenanceRequest(IMaintenanceRequest request);

    int getMaintenanceCost();

    IMaintenanceRequest getMaintenanceRequest();

    List<String> getFacilityProblems(); //pass in a request object

    double calcFacilityProblemRate();

    int getFacilityDownTime();

    void scheduleRequest(IMaintenanceSchedule ms);

    IMaintenanceLog getLog();

    List<IMaintenanceRequest> getRequestQueue();

    String listMaintenance();

    String listMaintenanceRequests();

    String listFacilityProblems();

    void setRequestQueue(List<IMaintenanceRequest> requestQueue);

    List<IMaintenanceOrder> getOrders();

    void setOrders(List<IMaintenanceOrder> orders);

    List<IMaintenanceSchedule> getSchedules();

    void setSchedules(List<IMaintenanceSchedule> schedules);

    void addOrderToLog(IMaintenanceOrder or);
}
