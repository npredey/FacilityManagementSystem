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
public class InspectionForm {

    private Date inspectionDate;
    private int inspectorID;
    private int facilityID;
    private String inspectionNotes;

    public InspectionForm(String inspectionDate, int inspectorID, int facilityID,
            String inspectionNotes) {
        this.inspectionDate = new Date(inspectionDate);
        this.inspectorID = inspectorID;
        this.facilityID = facilityID;
        this.inspectionNotes = inspectionNotes;
    }

    public void setfacilityID(int value) {
        facilityID = value;
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

    public int getfacilityID() {
        return facilityID;
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
}
