/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import com.OfficeBuilding.Inspection.FacilityInspection;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nickpredey
 */
public class FacilityUse implements IFacilityUse {

    private Date startTime;
    private Date endTime;
    private ArrayList<FacilityUser> users;
    private int capacity;
    private FacilityInspection inspection;

    public FacilityUse(String startTime, String endTime) {
        this.startTime = new Date(startTime);
        this.endTime = new Date(endTime);
        this.users = new ArrayList<>();
    }

    @Override
    public double getUsageRate() {
        return users.size() / ((double) capacity);

    }

    @Override
    public int getActualUsage() {
        return users.size();

    }

    @Override
    public void getInspections() {
        //implement inspection first

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

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public ArrayList<FacilityUser> getUsers() {
        return users;
    }

    public int getCapacity() {
        return capacity;
    }

    public FacilityInspection getInspection() {
        return inspection;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setUsers(ArrayList<FacilityUser> users) {
        this.users = users;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setInspection(FacilityInspection inspection) {
        this.inspection = inspection;
    }

}
