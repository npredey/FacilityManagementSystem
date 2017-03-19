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

    private List<InspectionFormInterface> forms;
    private InspectionLogInterface log;

    public List<InspectionFormInterface> getForms() {
        return forms;
    }

    public void setForms(List<InspectionFormInterface> forms) {
        this.forms = forms;
    }

    public FacilityInspection() {
        //forms = new ArrayList<>();
    }

    @Override
    public void inspect(InspectionFormInterface form) {
        forms.add(form);

    }

    @Override
    public void addInspectionToLog() {
        log.addForm(forms.remove(0));
    }

    @Override
    public InspectionLogInterface getLog() {
        return log;

    }

}
