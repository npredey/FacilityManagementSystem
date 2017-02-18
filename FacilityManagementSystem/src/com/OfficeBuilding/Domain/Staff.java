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
    private String getTimeofMaintenance(){
        //get time from view;
        return 12;
    }
    private getMaintenanceCost(){
        return new MaintenanceCost(10.0);//to be changed
    }
    @Override
    public void scheduleMaintenance(IFacility facility) {
        FacilityMaintenance maintain = facility.getMaintenance();
        MaintenanceRequest mr = maintain.getMaintenanceRequest();
        MaintenanceSchedule ms = new MaintenanceSchedule(getTimeofMaintenance(),mr);
        maintain.scheduleRequest(ms);

        getMaintenanceCost()

        MaintenanceOrder order = new MaintenanceOrder(getMaintenanceCost(),mr);
        maintain.addOrderToLog(order);


    }
    private String getProblem() {
        //get problem from view
        return "Pipe Problem";
    }
    private int getMaintenancePeriod(){
        //get Period from view
        return 12;
    }

    @Override
    public void makeMaintenanceRequest(IFacility facility) {


        MaintenanceRequesst request = new MaintenanceRequest(getMaintenancePeriod(),staffName,getProblem());
        facility.addMaintenanceRequest(request);



    }

}
