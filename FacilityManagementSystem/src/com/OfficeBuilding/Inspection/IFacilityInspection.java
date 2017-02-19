/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

/**
 *
 * @author nickpredey
 */
public interface IFacilityInspection {

    void inspect(InspectionForm form);

    void addInspectionToLog();

    void accept(InspectorVisitor inspectionVisitor);
}
