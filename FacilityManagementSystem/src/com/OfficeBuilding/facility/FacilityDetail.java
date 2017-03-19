/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + this.facilityID;
        hash = 73 * hash + this.capacity;
        hash = 73 * hash + Objects.hashCode(this.facilityBudget);
        hash = 73 * hash + Objects.hashCode(this.address);
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
        final FacilityDetail other = (FacilityDetail) obj;
        if (this.facilityID != other.facilityID) {
            return false;
        }
        if (this.capacity != other.capacity) {
            return false;
        }
        if (!Objects.equals(this.facilityBudget, other.facilityBudget)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

}
