/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceCost;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceOrder;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceSchedule;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;
import java.util.ArrayList;
import java.util.List;

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
        });

    }

    @Override
    public void visitUnit(Unit unit) {
        FacilityMaintenance maintain = unit.getMaintenance();
        MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
        maintain.addMaintenanceRequest(request);

    }

}
