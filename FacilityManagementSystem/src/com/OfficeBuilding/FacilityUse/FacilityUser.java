/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author nickpredey
 */
public class FacilityUser {

    private Date entryTime;
    private Date exitTime;
    private int userID;
    private String name;

    public FacilityUser(int entryTime, int userId, String userName) throws ParseException {
        this.entryTime = new Date(entryTime);
        this.userID = userId;
        this.name = userName;
    }

    public void setEntryTime(Date value) {
        entryTime = value;
    }

    public void setExitTime(Date value) {
        exitTime = value;
    }

    public void setName(String value) {
        name = value;
    }

    public void setUserID(int value) {
        userID = value;
    }

    public Date getEntryTime(Date value) {
        return entryTime;
    }

    public Date getExitTime(Date value) {
        return exitTime;
    }

    public String getName(String value) {
        return name;
    }

    public int getUserID(int value) {
        return userID;
    }
}
