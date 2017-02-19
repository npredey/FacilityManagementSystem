/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.Inspection.FacilityInspection;

/**
 *
 * @author nickpredey
 */
public class Unit implements IFacility {

    private FacilityDetail detail;
    private FacilityMaintenance maintenance;
    private FacilityInspection inspection;

    private void addNewUnitDetail(FacilityDetail d) {
        detail = d;
    }

    @Override
    public void addFacility(IFacility anyFacility) {
        anyFacility.addFacility(this);
    }

    @Override
    public void removeFacility(IFacility anyFacility) {
        anyFacility.removeFacility(this);
    }

    @Override
    public int getSize() {
        return 1;
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
        addNewUnitDetail(detail);
    }

    @Override
    public void acceptRequesterStaff(IFacilityDomain domain) {
        domain.makeMaintenanceRequestUnit(this);
    }

    @Override
    public void acceptScheduler(IFacilityDomain domain) {
        domain.scheduleMaintenanceUnit(this);
    }

    @Override
    public FacilityMaintenance getMaintenance() {
        return maintenance;
    }

    public FacilityDetail getDetail() {
        return detail;
    }

    public void setDetail(FacilityDetail detail) {
        this.detail = detail;
    }

    @Override
    public FacilityInspection getInspection() {
        return inspection;
    }
}
