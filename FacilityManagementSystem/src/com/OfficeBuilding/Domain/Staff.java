/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import static UtilityFunctions.UtilFunctions.getApplicationContext;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceCost;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceOrder;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceRequest;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceSchedule;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceOrder;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;
import java.util.Objects;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author nickpredey
 */
public class Staff implements IFacilityDomain {

    private String staffName;

    public Staff() {
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

    private int getTimeofMaintenance() {
        //get time from view;
        return 1200;
    }

    private IMaintenanceCost getMaintenanceCost() {
        ApplicationContext context = getApplicationContext();
        IMaintenanceCost cost = (IMaintenanceCost) context.getBean("maintenanceCost");
        cost.setDollarAmount(10.0);
        return cost;//to be changed
    }

    /**
     * Gets the maintenance log as a staff member
     *
     * @param building
     */
    @Override
    public void visitBuilding(Building building) {
        ApplicationContext context = getApplicationContext();
        building.getFacilities().stream().map((facility) -> facility.getMaintenance()).forEach((maintain) -> {

            IMaintenanceRequest mr = maintain.getMaintenanceRequest();
            IMaintenanceSchedule ms = (IMaintenanceSchedule) context.getBean("maintenanceSchedule");
            ms.setTimeOfMaintenance(getTimeofMaintenance());
            ms.setRequest(mr);
            //MaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(), mr);
            maintain.scheduleRequest(ms);
            building.getMaintenance().scheduleRequest(ms);
            getMaintenanceCost();

            IMaintenanceOrder order = (MaintenanceOrder) context.getBean("maintenanceOrder");
            order.setCost(getMaintenanceCost());
            order.setRequest(mr);

            //IMaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(), mr);
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
        ApplicationContext context = getApplicationContext();
        IFacilityMaintenance maintain = unit.getMaintenance();
        IMaintenanceRequest mr = maintain.getMaintenanceRequest();
        IMaintenanceSchedule ms = (IMaintenanceSchedule) context.getBean("maintenanceSchedule");
        ms.setTimeOfMaintenance(getTimeofMaintenance());
        ms.setRequest(mr);
        //IMaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(), mr);
        maintain.scheduleRequest(ms);

        getMaintenanceCost();

        IMaintenanceOrder order = (IMaintenanceOrder) context.getBean("maintenanceOrder");
        order.setCost(getMaintenanceCost());
        order.setRequest(mr);

        //MaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(), mr);
        maintain.addOrderToLog(order);

    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.staffName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Staff other = (Staff) obj;
        if (!Objects.equals(this.staffName, other.staffName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Staff{" + "staffName=" + staffName + '}';
    }

}
