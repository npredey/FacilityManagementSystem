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
public class MaintenanceOrder implements IMaintenanceOrder {

    private MaintenanceCost cost;
    private MaintenanceRequest request;

    public MaintenanceOrder(MaintenanceCost cost, MaintenanceRequest request) {
        this.cost = cost;
        this.request = request;
    }

    /**
     * Set the cost of a maintenance order.
     *
     * @param cost
     */
    @Override
    public void setCost(MaintenanceCost cost) {
        this.cost = cost;
    }

    /**
     * Sets an instance of a maintenance request.
     *
     * @param request
     */
    @Override
    public void setRequest(MaintenanceRequest request) {
        this.request = request;
    }

    /**
     * Gets the cost of this maintenance order.
     *
     * @return
     */
    @Override
    public MaintenanceCost getCost() {
        return cost;
    }

    /**
     * Gets the request that corresponds to this maintenance order object.
     *
     * @return
     */
    @Override
    public MaintenanceRequest getRequest() {
        return request;
    }
}
