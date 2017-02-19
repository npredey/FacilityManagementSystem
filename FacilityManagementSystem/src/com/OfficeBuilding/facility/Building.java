/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.Inspection.InspectionLog;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class Building implements IFacility {

    private FacilityMaintenance maintenance;
    FacilityDetail detail;

    public List<IFacility> facilities;

    public InspectionLog inspectionLog;

    public Building() {
        facilities = new ArrayList<>();
    }

    private void addNewFacilityDetail(FacilityDetail d) {
        detail = d;
    }

    public FacilityMaintenance getMaintenance() {
        return maintenance;
    }

    @Override
    public void addFacility(IFacility anyFacility) {
        facilities.add(anyFacility);
    }

    @Override
    public void removeFacility(IFacility anyFacility) {
        facilities.remove(anyFacility);
    }

    @Override
    public int getSize() {
        return facilities.size();
    }

    @Override
    public int getCapacity() {
        return detail.getCapacity();
    }

    @Override
    public FacilityDetail getFacilityDetail() {
        return detail;
    }

    @Override
    public void addNewDetail(FacilityDetail anyDetail) {
        addNewFacilityDetail(anyDetail);
    }

    public FacilityDetail getDetail() {
        return detail;
    }

    @Override
    public void acceptRequesterStaff(IFacilityDomain domain) {
        domain.makeMaintenanceRequest(this);
    }

    @Override
    public void acceptScheduler(IFacilityDomain domain) {

        domain.scheduleMaintenance(this);
    }

}
