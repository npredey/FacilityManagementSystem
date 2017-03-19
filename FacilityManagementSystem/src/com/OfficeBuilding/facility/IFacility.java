/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.IFacilityInspection;
import com.OfficeBuilding.Inspection.InspectionLog;
import com.OfficeBuilding.Inspection.InspectionLogInterface;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public interface IFacility {

    void addFacility(IFacility anyFacility);

    void removeFacility(IFacility anyFacility);

    int getSize();

    int getCapacity();

    IfacilityDetail getFacilityDetail();

    void addNewDetail(IfacilityDetail anyDetail);

    void accept(IFacilityDomain domain);

    IFacilityMaintenance getMaintenance();

    IFacilityInspection getInspection();

    InspectionLogInterface getInspections();

    int getUserNumber();

    public IFacilityUse getUsage();

    int requestAvailableCapacity();

    IfacilityDetail getFacilityInformation();

    String listFacilities();

}
