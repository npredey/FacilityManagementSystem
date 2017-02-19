package com.OfficeBuilding.Inspection;

import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.InspectorVisitor;
import java.util.Date;

/**
 * Created by Nathnael on 2/18/2017.
 */
public class Inspector implements InspectorVisitor {

    int inspectorId;

    public Inspector(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Override
    public void inspect(FacilityInspection fi) {
        String inspectionDate = getInspectionDate();
        String inspectionNote = getInspectionNote();
        InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
        fi.inspect(form);

    }

    private String getInspectionNote() {
        //get it from view
        return "good!";
    }

    private String getInspectionDate() {

        return "2/4/2016";

    }

    @Override
    public void inspect(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
