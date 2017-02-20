/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;

/**
 *
 * @author nickpredey
 */
public class Requester implements IFacilityDomain {

    private String staffName;

    public Requester(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    private String getProblem() {
        //get problem from view
        return "Pipe Problem";
    }

    private int getMaintenancePeriod() {
        //get Period from view
        return 12;
    }

    @Override
    public void visitBuilding(Building building) {
        building.getFacilities().stream().map((facility) -> facility.getMaintenance()).forEach((maintain) -> {
            MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
            maintain.addMaintenanceRequest(request);
            building.getMaintenance().addMaintenanceRequest(request);
            System.out.println("Made request");
        });
        System.out.println("Visiting Building");
    }

    @Override
    public void visitUnit(Unit unit) {
        FacilityMaintenance maintain = unit.getMaintenance();
        MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
        maintain.addMaintenanceRequest(request);

    }

}
