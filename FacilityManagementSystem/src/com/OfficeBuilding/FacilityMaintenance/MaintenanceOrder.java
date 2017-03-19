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
public class MaintenanceOrder implements IMaintenanceOrder {

    private IMaintenanceCost cost;
    private IMaintenanceRequest request;

    public MaintenanceOrder() {
//        this.cost = cost;
//        this.request = request;
    }

    /**
     * Set the cost of a maintenance order.
     *
     * @param cost
     */
    @Override
    public void setCost(IMaintenanceCost cost) {
        this.cost = cost;
    }

    /**
     * Sets an instance of a maintenance request.
     *
     * @param request
     */
    @Override
    public void setRequest(IMaintenanceRequest request) {
        this.request = request;
    }

    /**
     * Gets the cost of this maintenance order.
     *
     * @return
     */
    @Override
    public IMaintenanceCost getCost() {
        return cost;
    }

    /**
     * Gets the request that corresponds to this maintenance order object.
     *
     * @return
     */
    @Override
    public IMaintenanceRequest getRequest() {
        return request;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.cost);
        hash = 47 * hash + Objects.hashCode(this.request);
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
        final MaintenanceOrder other = (MaintenanceOrder) obj;
        if (!Objects.equals(this.cost, other.cost)) {
            return false;
        }
        if (!Objects.equals(this.request, other.request)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceOrder{" + "cost=" + cost + ", request=" + request + '}';
    }

}
