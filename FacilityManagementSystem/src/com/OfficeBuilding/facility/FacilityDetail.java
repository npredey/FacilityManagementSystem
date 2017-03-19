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
public class FacilityDetail implements IfacilityDetail{

    private int facilityID;
    private int capacity;
    private IFacilityBudget facilityBudget;
    private ILocation address;

    public FacilityDetail() {
    }

    public void setAddress(ILocation value) {
        address = value;
    }

    public void setCapacity(int value) {
        capacity = value;
    }

    public void setFacilityBudget(IFacilityBudget value) {
        facilityBudget = value;
    }

    public void setFacilityID(int value) {
        facilityID = value;
    }

    public ILocation getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }

    public IFacilityBudget getFacilityBudget() {
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
