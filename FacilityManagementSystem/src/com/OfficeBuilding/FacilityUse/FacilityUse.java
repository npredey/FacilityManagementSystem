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

    public Date startTime;
    public Date endTime;
    ArrayList<FacilityUser> users;
    int capacity;
    FacilityInspection inspection;

    public FacilityUse(String startTime, String endTime) {
        this.startTime = new Date(startTime);
        this.endTime = new Date(endTime);
        this.users = new ArrayList<>();
    }

    @Override
    public double getUsageRate() {
        return users.size()/((double)capacity);


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
        for(FacilityUser u: users){
            users.remove(u);
        }

    }

    @Override
    public void addUserToFacility(FacilityUser user) {
        users.add(user);

    }
}
