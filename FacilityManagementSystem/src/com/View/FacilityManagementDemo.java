package com.View;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.Domain.Staff;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.Inspection.IFacilityInspection;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Unit;

public class FacilityManagementDemo {

    public static void main(String[] args) {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        IFacilityInspection inspector = new IFacilityMaintenance();
        maintenance = new FacilityMaintenance(maintenanceLog);
        IFacilityDomain staff = new Staff("General Staff", maintenance);

        //create a Facility Domain
        //create an inspector object
        //create a FacilityUse Object
        //Call the methods in the interface
    }
}
