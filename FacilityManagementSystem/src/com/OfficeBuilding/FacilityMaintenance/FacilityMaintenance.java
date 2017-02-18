/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

/**
 *
 * @author nickpredey
 */
public class FacilityMaintenance implements IFacilityMaintenance {
    private static double NUM_DAYS_PER_YEAR = 365.0;

    private List<MaintenanceRequest> requestQueue = new ArrayList<>();
    private List<MaintenanceOrder> orders = new ArrayList<>();
    private List<MaintenanceSchedule> schedules = new ArrayList<>();

    MaintenanceLog log;

    public FacilityMaintenance(MaintenanceLog log){
        this.log = log;

    }

    @Override
    public void addMaintenanceRequest(MaintenanceRequest request) {
        requestQueue.add(request);
    }

    @Override
    public void createMaintenanceSchedule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getMaintenanceCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public MaintenanceRequest getMaintenanceRequest() {
        if (requestQueue.size() != 0){
            return requestQueue.get(0);
        }
        return null;
    }

    @Override
    public List<String> getFacilityProblems() {
        List<String> problems = new ArrayList<>();
        for (MaintenanceRequest mr : requestQueue){
            problems.add(mr.getProblem());
        }
        return problems;
    }

    @Override
    public void calcFacilityProblemRate() {
        List<String> problems = new ArrayList<>();
        for (MaintenanceRequest mr : requestQueue){
            problems.add(mr.getProblem());
        }
        double problemRate = problems.size()/NUM_DAYS_PER_YEAR;
        return problemRate;
    }

    @Override
    public void getFacillityDownTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void scheduleRequest(MaintenanceSchedule ms) {

        schedules.add(ms);
    }

}
