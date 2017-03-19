/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.FacilityUse;

/**
 *
 * @author Nathnael
 */
public interface IFacilityUser {
    void setEntryTime(int value);

    void setExitTime(int value);

    void setName(String value);

    void setUserID(int value);

    int getEntryTime();

    int getExitTime();

    String getName();

    int getUserID();
    
}
