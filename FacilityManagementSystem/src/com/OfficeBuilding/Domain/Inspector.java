package com.OfficeBuilding.Domain;

import com.OfficeBuilding.Inspection.InspectionForm;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;

/**
 * Created by Nathnael on 2/18/2017. The inspector visitor concrete class
 */
public class Inspector implements IFacilityDomain {

    int inspectorId;

    /**
     * Creates an inspector object with a unique ID.
     *
     * @param inspectorId
     */
    public Inspector() {}

    /**
     * Visits a building to perform an inspection
     *
     * @param build
     */
    @Override
    public void visitBuilding(Building build) {
        build.getFacilities().stream().forEach((f) -> {
            int inspectionDate = getInspectionDate();
            String inspectionNote = getInspectionNote();
            InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
            //set the inspectorId,InspectorNote and inspectionDate Separately
            f.getInspection().inspect(form);
            build.getInspection().inspect(form); //inspect the building
        });

    }
    
    public void setInspectorID(int inspectorId){
        this.inspectorId = inspectorId;
    }

    private String getInspectionNote() {
        //get it from view
        return "good!";
    }

    private int getInspectionDate() {
        return 600;

    }

    /**
     * Visits a unit to perform an inspection.
     *
     * @param unit
     */
    @Override
    public void visitUnit(Unit unit) {
        int inspectionDate = getInspectionDate();
        String inspectionNote = getInspectionNote();
        InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
        unit.getInspection().inspect(form);
    }

}
