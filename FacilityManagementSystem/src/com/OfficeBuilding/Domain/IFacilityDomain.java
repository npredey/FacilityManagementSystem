/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import com.OfficeBuilding.facility.IFacility;

/**
 *
 * @author nickpredey
 */
public interface IFacilityDomain {

    void scheduleMaintenanceBuilding(Building building);
    void scheduleMaintenanceUnit(Unit unit)

    void makeMaintenanceRequestBuilding(Building unit);
    void makeMaintenanceRequestUnit(Unit unit)

}
