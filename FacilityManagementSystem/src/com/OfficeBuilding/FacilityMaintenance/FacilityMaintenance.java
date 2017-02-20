/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class FacilityMaintenance implements IFacilityMaintenance {

    private final static double NUM_DAYS_PER_YEAR = 365.0;

    private List<MaintenanceRequest> requestQueue;
    private List<MaintenanceOrder> orders;
    private List<MaintenanceSchedule> schedules;

    private MaintenanceLog log;

    public MaintenanceLog getLog() {
        return log;
    }

    public void addOrderToLog(MaintenanceOrder or) {
        log.addToLog(or);
    }

    public FacilityMaintenance() {
        this.log = new MaintenanceLog();
        this.requestQueue = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    @Override
    public void addMaintenanceRequest(MaintenanceRequest request) {
        requestQueue.add(request);
    }

    @Override
    public void getMaintenanceCost() {
        int cost = 0;
        for (MaintenanceOrder l : orders) {
            cost += l.getCost().getDollarAmout();

        }
        return cost;
    }

    @Override
    public MaintenanceRequest getMaintenanceRequest() {
        if (!requestQueue.isEmpty()) {
            MaintenanceRequest mr = requestQueue.get(0);
            requestQueue.remove(mr);
            return mr;
        }
        return null;
    }

    @Override
    public List<String> getFacilityProblems() {
        List<String> problems = new ArrayList<>();
        for (MaintenanceRequest mr : requestQueue) {
            problems.add(mr.getProblem());
        }
        return problems;
    }

    @Override
    public double calcFacilityProblemRate() {
        List<String> problems = new ArrayList<>();
        for (MaintenanceRequest mr : requestQueue) {
            problems.add(mr.getProblem());
        }
        double problemRate = problems.size() / NUM_DAYS_PER_YEAR;
        return problemRate;
    }

    @Override
    public int getFacilityDownTime() {
        int time = 0;
        for (MaintenanceOrder mO : orders) {
            time += orders.getRequest().getMaintenancePeriod();
        }
        return time;

    }

    @Override
    public void scheduleRequest(MaintenanceSchedule ms) {
        schedules.add(ms);
    }

    public List<MaintenanceRequest> getRequestQueue() {
        return requestQueue;
    }

    public void setRequestQueue(List<MaintenanceRequest> requestQueue) {
        this.requestQueue = requestQueue;
    }

    public List<MaintenanceOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<MaintenanceOrder> orders) {
        this.orders = orders;
    }

    public List<MaintenanceSchedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<MaintenanceSchedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String listMaintenance() {
        String output = "";
        for (MaintenanceOrder l : log.getLogs()) {
            //no get dollar amount method
            output += "A problem of  " + l.getRequest().getProblem() + " requested by " + l.getRequest().getMaintenanceRequester() + " costs " + l.getDollarAmount();
            s += "\n";

        }
        return output;

    }

    @Override
    public String listMaintenanceRequests() {
        String output = "";
        for (MaintenanceRequest l : requestQueue) {
            s += "A problem of  " + l.getProblem() + " requested by " + l.getMaintenanceRequester() + " is under review";
            s += "\n";

        }
        return output;

    }

    @Override
    public String listFacilityProblems() {
        HashMap<String, Integer> problemOccurences = new HashMap<>();
        for (MaintenanceOrder l : log.getLogs()) {
            if (problemOccurences.containsKey(l.getRequest().getProblem())) {
                problemOccurences.put(l.getRequest().getProblem(), problemOccurences.get(l.getRequest().getProblem())++);
            } else {
                problemOccurences.put(l.getRequest().getProblem(), 1);
            }

        }
        String output = "";
        for (String keys : problemOccurences.keySet()) {
            output += "Problem: " + keys + " ||| Occurences: " + problemOccurences.get(keys);
            output += "\n";

        }
        return output;

    }

    @Override
    public void createMaintenanceSchedule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
