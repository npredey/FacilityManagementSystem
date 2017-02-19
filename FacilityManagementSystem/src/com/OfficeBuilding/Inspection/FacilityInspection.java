/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class FacilityInspection implements IFacilityInspection {

    List<InspectionForm> forms;
    InspectionLog log;

    public FacilityInspection() {
        forms = new ArrayList<>();
    }

    @Override
    public void inspect() {
        log.addForm(forms.remove(0));

    }

    @Override
    public void addInspectionToLog() {
        log.addForm(forms.remove(0));
    }

    @Override
    public void accept(InspectorVisitor inspectionVisitor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
