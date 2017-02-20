package com.OfficeBuilding.Domain;

import com.OfficeBuilding.Inspection.InspectionForm;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;

/**
 * Created by Nathnael on 2/18/2017.
 */
public class Inspector implements IFacilityDomain {

    int inspectorId;

    public Inspector(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Override
    public void visitBuilding(Building build) {
        build.getFacilities().stream().forEach((f) -> {
            String inspectionDate = getInspectionDate();
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

        return 600;

    }

    @Override
    public void visitUnit(Unit unit) {
        int inspectionDate = getInspectionDate();
        String inspectionNote = getInspectionNote();
        InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
        unit.getInspection().inspect(form);
    }

    @Override
    public void scheduleMaintenanceBuilding(Building building) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scheduleMaintenanceUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeMaintenanceRequestBuilding(Building unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void makeMaintenanceRequestUnit(Unit unit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
