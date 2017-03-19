/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class MaintenanceLog implements IMaintenanceLog {

    public List<MaintenanceOrder> orders;

    public MaintenanceLog() {
        this.orders = new ArrayList<>();
    }

    /**
     * Return this list of maintenance logs.
     *
     * @return
     */
    @Override
    public List<MaintenanceOrder> getLogs() {
        return orders;
    }

    /**
     * Add a maintenance order object to the maintenance log.
     *
     * @param order
     */
    @Override
    public void addToLog(MaintenanceOrder order) {
        orders.add(order);
    }
}
