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

    private List<IMaintenanceRequest> requestQueue;
    private List<IMaintenanceOrder> orders;
    private List<IMaintenanceSchedule> schedules;

    private IMaintenanceLog log;

    @Override
    public IMaintenanceLog getLog() {
        return log;
    }

    @Override
    public void addOrderToLog(IMaintenanceOrder or) {
        log.addToLog(or);
    }

    public FacilityMaintenance() {
        this.log = new MaintenanceLog();
        this.requestQueue = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.schedules = new ArrayList<>();
    }

    @Override
    public void addMaintenanceRequest(IMaintenanceRequest request) {
        System.out.println("Request queue before added request: " + requestQueue.size());
        requestQueue.add(request);
        System.out.println("Request queue after added request: " + requestQueue.size());

    }

    @Override
    public int getMaintenanceCost() {
        int cost = 0;
        for (IMaintenanceOrder l : log.getLogs()) {
            cost += l.getCost().getDollarAmount();

        }
        return cost;
    }

    @Override
    public IMaintenanceRequest getMaintenanceRequest() {
        if (!requestQueue.isEmpty()) {
            IMaintenanceRequest mr = requestQueue.get(0);
            requestQueue.remove(mr);
            return mr;
        }
        return null;
    }

    @Override
    public List<String> getFacilityProblems() {
        List<String> problems = new ArrayList<>();
        requestQueue.stream().forEach((mr) -> {
            problems.add(mr.getProblem());
        });
        return problems;
    }

    @Override
    public double calcFacilityProblemRate() {
        List<String> problems = new ArrayList<>();
        requestQueue.stream().forEach((mr) -> {
            problems.add(mr.getProblem());
        });
        double problemRate = problems.size() / NUM_DAYS_PER_YEAR;
        return problemRate;
    }

    @Override
    public int getFacilityDownTime() {
        int time = 0;
        time = log.getLogs().stream().map((mO) -> mO.getRequest().getMaintenancePeriod()).reduce(time, Integer::sum);
        return time;

    }

    @Override
    public void scheduleRequest(IMaintenanceSchedule ms) {
        schedules.add(ms);
    }

    @Override
    public List<IMaintenanceRequest> getRequestQueue() {
        return requestQueue;
    }

    @Override
    public void setRequestQueue(List<IMaintenanceRequest> requestQueue) {
        this.requestQueue = requestQueue;
    }

    @Override
    public List<IMaintenanceOrder> getOrders() {
        return orders;
    }

    @Override
    public void setOrders(List<IMaintenanceOrder> orders) {
        this.orders = orders;
    }

    @Override
    public List<IMaintenanceSchedule> getSchedules() {
        return schedules;
    }

    @Override
    public void setSchedules(List<IMaintenanceSchedule> schedules) {
        this.schedules = schedules;
    }

    @Override
    public String listMaintenance() {
        String output = "";
        for (MaintenanceOrder l : log.getLogs()) {
            //no get dollar amount method
            output += "A problem of  " + l.getRequest().getProblem() + " requested by " + l.getRequest().getMaintenanceRequester() + " costs " + l.getCost().getDollarAmount();
            output += "\n";

        }
        return output;

    }

    @Override
    public String listMaintenanceRequests() {
        String output = "";
        for (IMaintenanceRequest l : requestQueue) {
            output += "A problem of  " + l.getProblem() + " requested by " + l.getMaintenanceRequester() + " is under review";
            output += "\n";

        }
        return output;

    }

    @Override
    public String listFacilityProblems() {
        HashMap<String, Integer> problemOccurences = new HashMap<>();
        for (IMaintenanceOrder l : log.getLogs()) {
            if (problemOccurences.containsKey(l.getRequest().getProblem())) {
                problemOccurences.put(l.getRequest().getProblem(), problemOccurences.get(l.getRequest().getProblem()) + 1);
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
}
