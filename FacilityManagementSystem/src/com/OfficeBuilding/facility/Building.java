/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Inspection.InspectionLog;

/**
 *
 * @author nickpredey
 */
public class Building implements IFacility {
    FacilityMaintenance maintenance;
    FacilityDetail detail;

    List<IFacility> facilities;

    public InspectionLog inspectionLog;

    public Building(){
        facilities = new ArrayList<>();
    }

    public FacilityMaintenance getMaintenance() {
        return maintenance;
    }

    @Override
    public void addFacility(IFacility) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeFacility() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getSize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCapacity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getFacilityDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addNewDetail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
