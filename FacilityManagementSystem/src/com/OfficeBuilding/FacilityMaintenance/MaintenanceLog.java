/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author nickpredey
 */
public class MaintenanceLog implements IMaintenanceLog {

    public List<IMaintenanceOrder> orders;

    public MaintenanceLog() {
        //this.orders = new ArrayList<>();
    }

    public List<IMaintenanceOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<IMaintenanceOrder> orders) {
        this.orders = orders;
    }

    /**
     * Return this list of maintenance logs.
     *
     * @return
     */
    @Override
    public List<IMaintenanceOrder> getLogs() {
        return orders;
    }

    /**
     * Add a maintenance order object to the maintenance log.
     *
     * @param order
     */
    @Override
    public void addToLog(IMaintenanceOrder order) {
        orders.add(order);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.orders);
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
        final MaintenanceLog other = (MaintenanceLog) obj;
        if (!Objects.equals(this.orders, other.orders)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MaintenanceLog{" + "orders=" + orders + '}';
    }

}
