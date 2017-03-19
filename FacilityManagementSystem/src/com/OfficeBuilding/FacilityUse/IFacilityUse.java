/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

/**
 *
 * @author nickpredey
 */
public interface IFacilityUse {

    double getUsageRate();

    int getActualUsage();

    void vacateFacility();

    void addUserToFacility(IFacilityUser user);

    boolean isInUseDuringInterval(int time1, int time2);

    void setStartTime(int startTime);

    void setEndTime(int endTime);
}
