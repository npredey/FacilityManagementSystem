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
public class InspectionLog implements InspectionLogInterface {

    private List<InspectionFormInterface> inspections;

    public InspectionLog() {
        //this.inspections = new ArrayList<>();
    }

    @Override
    public void setInspections(List<InspectionFormInterface> value) {
        inspections = value;
    }

    @Override
    public List<InspectionFormInterface> getInspections() {
        return inspections;
    }

    @Override
    public void addForm(InspectionFormInterface form) {
        inspections.add(form);
    }

}
