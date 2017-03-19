package com.OfficeBuilding.Domain;

import static UtilityFunctions.UtilFunctions.getApplicationContext;
import com.OfficeBuilding.Inspection.InspectionForm;
import com.OfficeBuilding.Inspection.InspectionFormInterface;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Nathnael on 2/18/2017. The inspector visitor concrete class
 */
public class Inspector implements IFacilityDomain {

    private String staffName;

    /**
     * Creates an inspector object with a unique ID.
     *
     * @param inspectorId
     */
    public Inspector() {
    }

    /**
     * Visits a building to perform an inspection
     *
     * @param build
     */
    @Override
    public void visitBuilding(Building build) {
        ApplicationContext context = getApplicationContext();
        build.getFacilities().stream().forEach((f) -> {
            InspectionFormInterface form = (InspectionFormInterface) context.getBean("inspectionForm");
            int inspectionDate = getInspectionDate();
            String inspectionNote = getInspectionNote();
            form.setInspectionDate(inspectionDate);
            form.setInspectionNotes(inspectionNote);
            //set the inspectorId,InspectorNote and inspectionDate Separately
            f.getInspection().inspect(form);
            build.getInspection().inspect(form); //inspect the building
        });

    }

    @Override
    public String getStaffName() {
        return staffName;
    }

    @Override
    public void setStaffName(String staffName) {
        this.staffName = staffName;
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
        ApplicationContext context = getApplicationContext();
        int inspectionDate = getInspectionDate();
        String inspectionNote = getInspectionNote();
        InspectionFormInterface form = (InspectionFormInterface) context.getBean("inspectionForm");
        form.setInspectionDate(inspectionDate);
        form.setInspectionNotes(inspectionNote);
        //InspectionForm form = new InspectionForm(inspectionDate, inspectorId, inspectionNote);
        unit.getInspection().inspect(form);
    }

}
