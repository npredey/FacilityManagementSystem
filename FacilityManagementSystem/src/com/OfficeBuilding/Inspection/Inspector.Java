import java.util.Date;

package com.OfficeBuilding.Inspection;

/**
 * Created by Nathnael on 2/18/2017.
 */
public class Inspector implements InspectorVisitor {
    int inspectorId;

    public Inspector(int inspectorId){
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
}
