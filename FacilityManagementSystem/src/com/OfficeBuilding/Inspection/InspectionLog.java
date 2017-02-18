/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.ArrayList;

/**
 *
 * @author nickpredey
 */
public class InspectionLog {

    private ArrayList<InspectionForm> inspections;

    public InspectionLog() {
        this.inspections = new ArrayList<>();
    }

    public void setInspections(ArrayList<InspectionForm> value) {
        inspections = value;
    }

    public ArrayList<InspectionForm> setInspections() {
        return inspections;
    }
}
