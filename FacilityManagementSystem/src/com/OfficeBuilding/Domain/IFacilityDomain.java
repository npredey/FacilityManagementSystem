/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Domain;

import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Unit;

/**
 *
 * @author nickpredey
 */
public interface IFacilityDomain {


    void visitBuilding(Building building);

    void visitUnit(Unit unit);

}
