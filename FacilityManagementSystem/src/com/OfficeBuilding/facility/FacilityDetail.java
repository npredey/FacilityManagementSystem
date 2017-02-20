/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

/**
 *
 * @author nickpredey
 */
public class FacilityDetail {

    private int facilityID;
    private int capacity;
    private FacilityBudget facilityBudget;
    private Location address;

    public FacilityDetail(int facilityID, int facilityCapacity, FacilityBudget budget,
            Location location) {
        this.facilityID = facilityID;
        this.capacity = facilityCapacity;
        this.facilityBudget = budget;
        this.address = location;
    }

    public void setAddress(Location value) {
        address = value;
    }

    public void setCapacity(int value) {
        capacity = value;
    }

    public void setFacilityBudget(FacilityBudget value) {
        facilityBudget = value;
    }

    public void setFacilityID(int value) {
        facilityID = value;
    }

    public Location getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public FacilityBudget getFacilityBudget() {
        return facilityBudget;
    }

    public int getFacilityID() {
        return facilityID;
    }

    @Override
    public String toString() {
        return "FacilityDetail{" + "facilityID=" + facilityID + ", capacity=" + capacity + ", facilityBudget=" + facilityBudget.toString() + ", address=" + address.toString() + '}';
    }

}
