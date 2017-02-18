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
public interface IFacility {

    public void addFacility();

    public void removeFacility();

    public void getSize();

    public void getCapacity();

    public void getFacilityDetail();

    public void addNewDetail();
    void acceptRequesterStaff(IFacilityDomain domain);
    void acceptScheduler(IFacilityDomain domain);
    FacilityMaintenance getMaintenance();
}
