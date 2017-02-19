package com.View;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.Domain.Staff;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.FacilityUse.FacilityUse;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.IFacilityInspection;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.FacilityBudget;
import com.OfficeBuilding.facility.FacilityDetail;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Location;
import com.OfficeBuilding.facility.Unit;

public class FacilityManagementDemo {

    public static void main(String[] args) {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        Location facilityLocation = new Location("Chicago Avenue", "123", "Chicago", "IL", 60660, "US");
        FacilityBudget facilityBudget = new FacilityBudget(100000, 50000);
        FacilityDetail detailDemo = new FacilityDetail(1, 100, facilityBudget, facilityLocation);

        IFacilityInspection inspector = new FacilityInspection();
        IFacilityMaintenance maintenance = new FacilityMaintenance(maintenanceLog);
        Unit[] units = {new Unit(detail, maintenance, inspector)};
        IFacility facility = new Building(units);
        IFacilityDomain staff = new Staff("General Staff", maintenance);
        IFacilityUse facilityUse = new FacilityUse("9:00:00", "19:00:00", facility)
        System.out.println("-----------------------DONE-----------------------");
        //create a Facility Domain
        //create an inspector object
        //create a FacilityUse Object
        //Call the methods in the interface
    }
}
