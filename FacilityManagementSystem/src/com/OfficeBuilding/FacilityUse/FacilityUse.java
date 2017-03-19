/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import java.util.List;
import java.util.Objects;

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

    @Override
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
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
        for (IFacilityUser f : users) {
            System.out.println("Name of user: " + f.getName());
            System.out.println("Entry time: " + f.getEntryTime());
            if (f.getEntryTime() >= time1 && f.getEntryTime() <= time2) {
                return true;
            }
        }
        return false;

    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + this.startTime;
        hash = 61 * hash + this.endTime;
        hash = 61 * hash + Objects.hashCode(this.users);
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
        final FacilityUse other = (FacilityUse) obj;
        if (this.startTime != other.startTime) {
            return false;
        }
        if (this.endTime != other.endTime) {
            return false;
        }
        if (!Objects.equals(this.users, other.users)) {
            return false;
        }
        return true;
    }

}
