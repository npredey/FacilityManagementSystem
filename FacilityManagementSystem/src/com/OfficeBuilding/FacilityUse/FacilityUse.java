/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author nickpredey
 */
public class FacilityUse implements IFacilityUse {

    private int startTime;
    private int endTime;
    private ArrayList<FacilityUser> users;

    public FacilityUse(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.users = new ArrayList<>();
    }

    @Override
    public double getUsageRate() {
        return users.size() / 24.0; //number of people per hour

    }

    @Override
    public int getActualUsage() {
        return users.size();

    }

    @Override
    public void vacateFacility() {
        for (int i = 0; i < users.size(); i++) {
            users.remove(0);
        }
    }

    @Override
    public void addUserToFacility(FacilityUser user) {
        users.add(user);

    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public ArrayList<FacilityUser> getUsers() {
        return users;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setUsers(ArrayList<FacilityUser> users) {
        this.users = users;
    }

    @Override
    public boolean isInUseDuringInterval(int time1, int time2) {
        Date t1 = new Date(time1);
        Date t2 = new Date(time2);
        for (FacilityUser u : users) {
            if (u.getEntryTime().before(t1) && u.getExitTime().after(t2)) {
                return true;
            }
        }
        return false;

    }
}
