/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceCost;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceOrder;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceSchedule;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Unit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class Staff implements IFacilityDomain {

    private List<MaintenanceSchedule> schedules;
    private FacilityMaintenance maintenance;
    private String staffName;

    public Staff(String staffName, FacilityMaintenance maintenance) {
        this.maintenance = maintenance;
        this.staffName = staffName;
        this.schedules = new ArrayList<>();
    }

    public List<MaintenanceSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<MaintenanceSchedule> schedules) {
        this.schedules = schedules;
    }

    public FacilityMaintenance getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(FacilityMaintenance maintenance) {
        this.maintenance = maintenance;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    private String getTimeofMaintenance() {
        //get time from view;
        return Integer.toString(12);
    }

    private MaintenanceCost getMaintenanceCost() {
        return new MaintenanceCost(10.0);//to be changed
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
    public void scheduleMaintenanceBuilding(Building building) {

        building.getFacilities().stream().map((facility) -> facility.getMaintenance()).forEach((maintain) -> {
            MaintenanceRequest mr = maintain.getMaintenanceRequest();
            MaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(), mr);
            maintain.scheduleRequest(ms);

            getMaintenanceCost();

            MaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(), mr);
            maintain.addOrderToLog(order);
        });

    }

    @Override
    public void scheduleMaintenanceUnit(Unit unit) {
        FacilityMaintenance maintain = unit.getMaintenance();
        MaintenanceRequest mr = maintain.getMaintenanceRequest();
        MaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(), mr);
        maintain.scheduleRequest(ms);

        getMaintenanceCost();

        MaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(), mr);
        maintain.addOrderToLog(order);

    }

    @Override
    public void makeMaintenanceRequestBuilding(Building unit) {
        unit.getFacilities().stream().map((facility) -> facility.getMaintenance()).forEach((maintain) -> {
            MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
            maintain.addMaintenanceRequest(request);
        });

    }

    @Override
    public void makeMaintenanceRequestUnit(Unit unit) {
        FacilityMaintenance maintain = unit.getMaintenance();
        MaintenanceRequest request = new MaintenanceRequest(getMaintenancePeriod(), staffName, getProblem());
        maintain.addMaintenanceRequest(request);

    }

}
