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
public class FacilityDetail implements IfacilityDetail {

    private int facilityID;
    private int capacity;
    private IFacilityBudget facilityBudget;
    private ILocation address;

    public FacilityDetail() {
    }

    @Override
    public void setAddress(ILocation value) {
        address = value;
    }

    @Override
    public void setCapacity(int value) {
        capacity = value;
    }

    @Override
    public void setFacilityBudget(IFacilityBudget value) {
        facilityBudget = value;
    }

    @Override
    public void setFacilityID(int value) {
        facilityID = value;
    }

    @Override
    public ILocation getAddress() {
        return address;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public IFacilityBudget getFacilityBudget() {
        return facilityBudget;
    }

    @Override
    public int getFacilityID() {
        return facilityID;
    }

    @Override
    public String toString() {
        return "FacilityDetail{" + "facilityID=" + facilityID + ", capacity=" + capacity + ", facilityBudget=" + facilityBudget.toString() + ", address=" + address.toString() + '}';
    }

}
