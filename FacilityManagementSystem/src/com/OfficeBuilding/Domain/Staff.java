/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

/**
 *
 * @author nickpredey
 */
public class Staff implements IFacilityDomain {
    List<MaintenanceSchedule> schedules = new ArrayList<>();
    FacilityMaintenance maintenance;
    String  staffName;

    public Staff(String staffName, FacilityMaintenance maintenance){
        this.maintenance = maintenance;
        this.staffName = staffName;

    }
    @Override
    public void scheduleMaintenance(IFacility facility) {
        FacilityMaintenance maintain = facility.getMaintenance();
        maintain.getMaintenanceRequest();
        //create a Maintenance Schedule object

        //add the maintenance Request object

    }

    @Override
    public void makeMaintenanceRequest(IFacility facility) {
        //createa a Maintenance request object
        //add the maintenance request object into the requests list

    }

}
