/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class FacilityUse implements IFacilityUse {

    private int startTime;
    private int endTime;
    private List<IFacilityUser> users;

    public FacilityUse() {
//        this.startTime = startTime;
//        this.endTime = endTime;
//        this.users = new ArrayList<>();
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
    public void addUserToFacility(IFacilityUser user) {
        users.add(user);

    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public List<IFacilityUser> getUsers() {
        return users;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public void setUsers(List<IFacilityUser> users) {
        this.users = users;
    }

    /**
     * Checks if there are any users in the facility during a time period. Time
     * is in military time (0001-2400)
     *
     * @param time1
     * @param time2
     * @return
     */
    @Override
    public boolean isInUseDuringInterval(int time1, int time2) {
        return users.stream().map((u) -> {
            return u;
        }).anyMatch((u) -> (u.getEntryTime() >= time1 && u.getEntryTime() <= time2));

    }
}
