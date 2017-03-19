/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.Date;

/**
 *
 * @author nickpredey
 */
public class InspectionForm implements InspectionFormInterface {

    private int inspectionDate;
    private int inspectorID;

    private String inspectionNotes;

    public InspectionForm() {
//        this.inspectionDate = inspectionDate;
//        this.inspectorID = inspectorID;
//        this.inspectionNotes = inspectionNotes;
    }

    @Override
    public void setInspectionDate(int value) {
        inspectionDate = value;
    }

    @Override
    public void setInspectorID(int value) {
        inspectorID = value;
    }

    @Override
    public void setInspectionNotes(String value) {
        inspectionNotes = value;
    }

    @Override
    public int getInspectionDate() {
        return inspectionDate;
    }

    @Override
    public int getInspectorID() {
        return inspectorID;
    }

    @Override
    public String getInspectionNotes() {
        return inspectionNotes;
    }

    @Override
    public String toString() {
        return "InspectionForm{" + "inspectionDate=" + inspectionDate + ", "
                + "inspectorID=" + inspectorID + ", inspectionNotes=" + inspectionNotes + '}';
    }

}
