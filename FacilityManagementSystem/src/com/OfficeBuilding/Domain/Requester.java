/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import static UtilityFunctions.UtilFunctions.getApplicationContext;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceRequest;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author nickpredey
 */
public class Requester implements IFacilityDomain {

    private String staffName;

    public Requester() {
        //this.staffName = staffName;
    }

    @Override
    public String getStaffName() {
        return staffName;
    }

    @Override
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

    /**
     * Visits a building to request maintenance
     *
     * @param building
     */
    @Override
    public void visitBuilding(Building building) {
        ApplicationContext context = getApplicationContext();
        building.getFacilities().stream().map((facility) -> facility.getMaintenance()).forEach((maintain) -> {
            IMaintenanceRequest request = (IMaintenanceRequest) context.getBean("maintenanceRequest");
            request.setMaintenancePeriod(getMaintenancePeriod());
            request.setMaintenanceRequester(staffName);
            request.setProblem(getProblem());
            //MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
            maintain.addMaintenanceRequest(request);
            building.getMaintenance().addMaintenanceRequest(request);
            System.out.println("Made request from requester: " + staffName);
        });
        System.out.println("Visiting Building....");
    }

    /**
     * Visits a unit to request maintenance.
     *
     * @param unit
     */
    @Override
    public void visitUnit(Unit unit) {
        ApplicationContext context = getApplicationContext();
        FacilityMaintenance maintain = unit.getMaintenance();
        IMaintenanceRequest request = (IMaintenanceRequest) context.getBean("maintenanceRequest");
        request.setMaintenancePeriod(getMaintenancePeriod());
        request.setMaintenanceRequester(staffName);
        request.setProblem(getProblem());
        //MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
        maintain.addMaintenanceRequest(request);

    }

}
