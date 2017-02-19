/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.InspectionLog;
import com.OfficeBuilding.facility.IFacility;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nickpredey
 */
public class FacilityUse implements IFacilityUse {

    private String startTime;
    private String endTime;
    private ArrayList<FacilityUser> users;
    IFacility facility;

    public FacilityUse(String startTime, String endTime, IFacility facility) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.users = new ArrayList<>();
        this.facility = facility;
    }

    @Override
    public double getUsageRate() {
        return users.size() / ((double) facility.getCapacity()); //need to get the capacity

    }

    @Override
    public int getActualUsage() {
        return users.size();

    }

    @Override
    public InspectionLog getInspections() {
        return facility.getInspection().getLog();

    }

    @Override
    public void vacateFacility() {
        for (FacilityUser u : users) {
            users.remove(u);
        }

    }

    @Override
    public void addUserToFacility(FacilityUser user) {
        users.add(user);

    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public ArrayList<FacilityUser> getUsers() {
        return users;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setUsers(ArrayList<FacilityUser> users) {
        this.users = users;
    }

}
