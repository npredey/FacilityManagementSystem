/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityMaintenance;

/**
 *
 * @author nickpredey
 */
public interface IMaintenanceRequest {

    void setMaintenancePeriod(int value);

    void setMaintenanceRequester(String value);

    void setProblem(String value);

    int getMaintenancePeriod();

    String getMaintenanceRequester();

    String getProblem();
}
