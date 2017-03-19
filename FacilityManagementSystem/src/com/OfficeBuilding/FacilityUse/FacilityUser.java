/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.entryTime;
        hash = 89 * hash + this.exitTime;
        hash = 89 * hash + this.userID;
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final FacilityUser other = (FacilityUser) obj;
        if (this.entryTime != other.entryTime) {
            return false;
        }
        if (this.exitTime != other.exitTime) {
            return false;
        }
        if (this.userID != other.userID) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacilityUser{" + "entryTime=" + entryTime + ", exitTime=" + exitTime + ", userID=" + userID + ", name=" + name + '}';
    }

}
