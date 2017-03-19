/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import com.OfficeBuilding.facility.Building;
import java.text.ParseException;
import java.util.Date;
import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nickpredey
 */
public class FacilityUser implements IFacilityUser {

    private int entryTime;
    private int exitTime;
    private int userID;
    private String name;

    public FacilityUser() {
//        if (entryTime > 0 || entryTime <= 2400) {
//            this.entryTime = entryTime;
//        } else {
//            try {
//                this.entryTime = -1;
//                throw new java.lang.Exception("That time does not exist: user entry time incorrect");
//            } catch (Exception ex) {
//                Logger.getLogger(Building.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        this.userID = userId;
//        this.name = userName;
    }

    @Override
    public void setEntryTime(int value) {
        entryTime = value;
    }

    @Override
    public void setExitTime(int value) {
        exitTime = value;
    }

    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public void setUserID(int value) {
        userID = value;
    }

    @Override
    public int getEntryTime() {
        return entryTime;
    }

    @Override
    public int getExitTime() {
        return exitTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getUserID() {
        return userID;
    }
}
