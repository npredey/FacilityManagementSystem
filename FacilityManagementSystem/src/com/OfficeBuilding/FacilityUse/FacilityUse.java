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
public class FacilityUse {

    public Date startTime;
    public Date endTime;
    ArrayList<FacilityUser> users;

    public FacilityUse(String startTime, String endTime) {
        this.startTime = new Date(startTime);
        this.endTime = new Date(endTime);
        this.users = new ArrayList<>();
    }
}
