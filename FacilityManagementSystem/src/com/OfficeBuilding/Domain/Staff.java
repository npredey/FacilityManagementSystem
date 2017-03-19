/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceOrder;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceRequest;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceSchedule;
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
public class Staff implements IFacilityDomain {

    private String staffName;

    public Staff(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    private int getTimeofMaintenance() {
        //get time from view;
        return 1200;
    }

    private MaintenanceCost getMaintenanceCost() {
        return new MaintenanceCost(10.0);//to be changed
    }

    /**
     * Gets the maintenance log as a staff member
     *
     * @param building
     */
    @Override
    public void visitBuilding(Building building) {

        building.getFacilities().stream().map((facility) -> facility.getMaintenance()).forEach((maintain) -> {
            IMaintenanceRequest mr = maintain.getMaintenanceRequest();
            MaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(), mr);
            maintain.scheduleRequest(ms);
            building.getMaintenance().scheduleRequest(ms);
            getMaintenanceCost();

            IMaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(), mr);
            maintain.addOrderToLog(order);
            building.getMaintenance().addOrderToLog(order);
        });

    }

    /**
     * Visits a unit to get the maintenance log.
     *
     * @param unit
     */
    @Override
    public void visitUnit(Unit unit) {
        FacilityMaintenance maintain = unit.getMaintenance();
        IMaintenanceRequest mr = maintain.getMaintenanceRequest();
        IMaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(), mr);
        maintain.scheduleRequest(ms);

        getMaintenanceCost();

        MaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(), mr);
        maintain.addOrderToLog(order);

    }

}
