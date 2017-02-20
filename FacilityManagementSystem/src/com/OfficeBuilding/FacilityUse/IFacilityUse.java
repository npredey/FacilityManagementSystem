/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

import com.OfficeBuilding.Inspection.InspectionLog;

/**
 *
 * @author nickpredey
 */
public interface IFacilityUse {

    public double getUsageRate();

    public int getActualUsage();

    public void vacateFacility();

    public void addUserToFacility(FacilityUser user);

    boolean isInUseDuringInterval(int time1, int time2);
}
