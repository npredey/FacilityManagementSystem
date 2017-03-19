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

    public void setLog(InspectionLogInterface log) {
        this.log = log;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.forms);
        hash = 97 * hash + Objects.hashCode(this.log);
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
        final FacilityInspection other = (FacilityInspection) obj;
        if (!Objects.equals(this.forms, other.forms)) {
            return false;
        }
        if (!Objects.equals(this.log, other.log)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FacilityInspection{" + "forms=" + forms + ", log=" + log + '}';
    }

}
