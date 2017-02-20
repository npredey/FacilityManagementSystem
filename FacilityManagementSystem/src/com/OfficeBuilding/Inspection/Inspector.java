package com.OfficeBuilding.Inspection;

import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;

/**
 * Created by Nathnael on 2/18/2017.
 */
public class Inspector implements InspectorVisitor {

    int inspectorId;

    public Inspector(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Override
    public void inspectBuilding(Building build) {
        build.getFacilities().stream().forEach((f) -> {
            int inspectionDate = getInspectionDate();
            String inspectionNote = getInspectionNote();
            InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
            f.getInspection().inspect(form);
        });

    }

    private String getInspectionNote() {
        //get it from view
        return "good!";
    }

    private int getInspectionDate() {

        return 500;

    }

    @Override
    public void inspectUnit(Unit unit) {
        int inspectionDate = getInspectionDate();
        String inspectionNote = getInspectionNote();
        InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
        unit.getInspection().inspect(form);
    }
}
