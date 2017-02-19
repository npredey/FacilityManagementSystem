/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;
import com.OfficeBuilding.Inspection.FacilityInspection;

/**
 *
 * @author nickpredey
 */
public interface IFacility {

    void addFacility(IFacility anyFacility);

    void removeFacility(IFacility anyFacility);

    int getSize();

    int getCapacity();

    FacilityDetail getFacilityDetail();

    void addNewDetail(FacilityDetail anyDetail);

    void accept(IFacilityDomain domain)

    FacilityMaintenance getMaintenance();

    FacilityInspection getInspection();

}
