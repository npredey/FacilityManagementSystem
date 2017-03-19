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
public interface IMaintenanceSchedule {

    void setTimeOfMaintenance(int value);

    int getTimeOfMaintenance();

    IMaintenanceRequest getRequest();

    void setRequest(IMaintenanceRequest request);
}
