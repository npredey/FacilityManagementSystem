/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.inspectionDate;
        hash = 67 * hash + this.inspectorID;
        hash = 67 * hash + Objects.hashCode(this.inspectionNotes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InspectionForm other = (InspectionForm) obj;
        if (this.inspectionDate != other.inspectionDate) {
            return false;
        }
        if (this.inspectorID != other.inspectorID) {
            return false;
        }
        if (!Objects.equals(this.inspectionNotes, other.inspectionNotes)) {
            return false;
        }
        return true;
    }

}
