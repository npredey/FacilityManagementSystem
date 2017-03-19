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
public interface IMaintenanceLog {

    List<IMaintenanceOrder> getLogs();

    void addToLog(IMaintenanceOrder order);
}
