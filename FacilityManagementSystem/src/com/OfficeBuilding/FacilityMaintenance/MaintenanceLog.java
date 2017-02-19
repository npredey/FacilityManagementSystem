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
public class MaintenanceLog {

    public List<MaintenanceOrder> orders;

    public MaintenanceLog() {
        this.orders = new ArrayList<>();
    }

    public List<MaintenanceOrder> getLogs() {
        return orders;
    }

    public void addToLog(MaintenanceOrder order) {
        orders.add(order);
    }
}
