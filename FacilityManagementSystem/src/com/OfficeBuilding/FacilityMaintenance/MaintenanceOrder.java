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
public class MaintenanceOrder {
    private MaintenanceCost cost;
    private MaintenanceRequest request;

    public MaintenanceOrder(MaintenanceCost cost, MaintenanceRequest request){
        this.cost = cost;
        this.request = request;
    }

    public MaintenanceCost getCost() {
        return cost;
    }

    public MaintenanceRequest getRequest() {
        return request;
    }
}
