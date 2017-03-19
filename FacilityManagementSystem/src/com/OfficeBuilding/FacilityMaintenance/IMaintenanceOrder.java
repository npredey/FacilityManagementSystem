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
public interface IMaintenanceOrder {

    void setCost(MaintenanceCost cost);

    void setRequest(MaintenanceRequest request);

    MaintenanceCost getCost();

    MaintenanceRequest getRequest();
}
