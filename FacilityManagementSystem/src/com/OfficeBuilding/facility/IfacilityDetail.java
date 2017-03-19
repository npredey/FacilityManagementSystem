/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

/**
 *
 * @author Nathnael
 */
public interface IfacilityDetail {

    public void setAddress(ILocation value);

    public void setCapacity(int value);

    public void setFacilityBudget(IFacilityBudget value);

    public void setFacilityID(int value);

    public ILocation getAddress();

    public int getCapacity();

    public IFacilityBudget getFacilityBudget();

    public int getFacilityID();

    @Override
    public String toString();

}
