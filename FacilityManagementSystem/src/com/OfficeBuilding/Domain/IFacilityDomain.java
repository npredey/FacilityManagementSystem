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

    void scheduleMaintenance(IFacility facility);

    void makeMaintenanceRequest(IFacility facility);

}
