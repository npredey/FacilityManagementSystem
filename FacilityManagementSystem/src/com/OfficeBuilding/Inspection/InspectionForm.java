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
public class InspectionForm implements InspectionFormInterface{

    private Date inspectionDate;
    private int inspectorID;

    private String inspectionNotes;
    public InspectionForm(){}
    

    public InspectionForm(int inspectionDate, int inspectorID,
            String inspectionNotes) {
        this.inspectionDate = new Date(inspectionDate);
        this.inspectorID = inspectorID;
        this.inspectionNotes = inspectionNotes;
    }

    public void setInspectionDate(Date value) {
        inspectionDate = value;
    }

    public void setInspectorID(int value) {
        inspectorID = value;
    }

    public void setInspectionNotes(String value) {
        inspectionNotes = value;
    }

    public Date getInspectionDate() {
        return inspectionDate;
    }

    public int getInspectorID() {
        return inspectorID;
    }

    public String getInspectionNotes() {
        return inspectionNotes;
    }

    @Override
    public String toString() {
        return "InspectionForm{" + "inspectionDate=" + inspectionDate + ", "
                + "inspectorID=" + inspectorID + ", inspectionNotes=" + inspectionNotes + '}';
    }

}
