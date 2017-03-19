/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.List;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.inspections);
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
        final InspectionLog other = (InspectionLog) obj;
        return Objects.equals(this.inspections, other.inspections);
    }

    @Override
    public String toString() {
        return "InspectionLog{" + "inspections=" + inspections + '}';
    }

}
