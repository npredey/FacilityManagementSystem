package com.View;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.Domain.Inspector;
import com.OfficeBuilding.Domain.Staff;
import com.OfficeBuilding.Facade.FacilityMaintenanceConcrete;
import com.OfficeBuilding.Facade.FacilityMaintenanceFacade;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.FacilityUse.FacilityUse;
import com.OfficeBuilding.FacilityUse.FacilityUser;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.Inspection.InspectionForm;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.FacilityBudget;
import com.OfficeBuilding.facility.FacilityDetail;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Location;
import com.OfficeBuilding.facility.Unit;
import java.text.ParseException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FacilityManagementDemo {

    /*Constants Related to budget*/
    public static int testSavings0 = 1000000;
    public static int testOperatingBudget0 = 500000;
    public static int testSavings1 = 100000;
    public static int testOperatingBudget1 = 50000;
    public static int testSavings2 = 150000;
    public static int testOperatingBudget2 = 55000;
    public static int testSavings3 = 1000;
    public static int testOperatingBudget3 = 5000;

    /*Constants Related to Location*/
    public static String testStreetName = "Chicago Avenue";
    public static String testStreetNumber = "123";
    public static String testCity = "Chicago";
    public static String testState = "IL";
    public static int testZipCode = 60660;
    public static String testCountry = "US";

    /*Constants related to Staff*/
    public static String testStaffName = "General Staff";

    /*Constants related to Units*/
    public static int capacityUnit1 = 100;
    public static int capacityUnit2 = 150;
    public static int capacityUnit3 = 300;

    public static void main(String[] args) throws ParseException {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        Location facilityLocation = new Location(testStreetName, testStreetNumber,
                testCity, testState, testZipCode, testCountry);

        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/app-context.xml");

        FacilityBudget facilityBudgetBuilding = new FacilityBudget(testSavings0, testOperatingBudget0);
        FacilityBudget facilityBudgetUnit1 = new FacilityBudget(testSavings1, testOperatingBudget1);
        FacilityBudget facilityBudgetUnit2 = new FacilityBudget(testSavings2, testOperatingBudget2);
        FacilityBudget facilityBudgetNewUnit = new FacilityBudget(testSavings3, testOperatingBudget3);

        FacilityDetail detailDemoBuilding = new FacilityDetail(0, -1, facilityBudgetBuilding, facilityLocation);
        FacilityDetail detailDemoUnit1 = new FacilityDetail(1, capacityUnit1, facilityBudgetUnit1, facilityLocation);
        FacilityDetail detailDemoUnit2 = new FacilityDetail(2, capacityUnit2, facilityBudgetUnit2, facilityLocation);
        FacilityDetail detailTestNewUnit = new FacilityDetail(3, capacityUnit3, facilityBudgetNewUnit, facilityLocation);

        Unit[] units = {new Unit(detailDemoUnit1), new Unit(detailDemoUnit2)};
        IFacility facility = new Building(units);
        facility.addNewDetail(detailDemoBuilding);
        System.out.println("Initial capacity (should be 250): " + facility.getCapacity());
        System.out.println("Requesting available capacity...: " + facility.requestAvailableCapacity());
        System.out.println("Printing facility information: " + facility.getFacilityInformation());
        System.out.println("List of facilities: \n" + facility.listFacilities());

        IFacilityDomain staff = new Staff(testStaffName);
        IFacilityUse facilityUse = new FacilityUse(900, 1900);

        IFacility newUnit = new Unit(detailTestNewUnit);
        facility.addFacility(newUnit);
        System.out.println("Capacity after new unit (new unit cannot be added): " + facility.getCapacity());

        //create a Facility Domain
        //create an inspector object
        //create a FacilityUse Object
        //Call the methods in the interface
        //test for inspection class
        FacilityMaintenanceFacade maintenance = new FacilityMaintenanceConcrete(facility);
        //request maintenance *7
        for (int i = 0; i < 7; i++) {
            maintenance.makeFacilityMaintRequest();
        }
        for (int i = 0; i < 4; i++) {
            maintenance.scheduleMaintenance();
        }
        System.out.println("Building request queue size: " + facility.getMaintenance().getRequestQueue().size());
        System.out.println("Total maintenance cost: " + maintenance.calculateMaintenanceCostForFacility());
        System.out.println("Problem rate: " + maintenance.calcProblemRateForFacility());
        System.out.println("Downtime: " + maintenance.calcDownTimeForFacility());

        System.out.println("Maintenance Requests: ");
        System.out.println(maintenance.listMaintRequests());

        System.out.println("\n List of Maintenances: \n");
        System.out.println(maintenance.listMaintenance());

        System.out.println("\n List of Problems: \n");
        System.out.println(maintenance.listFacilityProblems());

        //check inspection
        IFacilityDomain inspector = new Inspector(12);
        facility.accept(inspector);
        facility.accept(inspector);
        facility.accept(inspector);

        for (InspectionForm il : facility.getInspections().getInspections()) {
            System.out.println("Inspector ID: " + il.getInspectorID());
        }

        //call the rest of the methods
        //test for facility use
        IFacilityUse use = new FacilityUse(800, 1700);

        use.addUserToFacility(new FacilityUser(800, 1, "jorge castro"));
        use.addUserToFacility(new FacilityUser(800, 2, "james miller"));
        use.addUserToFacility(new FacilityUser(800, 3, "Yi Lee"));
        use.addUserToFacility(new FacilityUser(800, 4, "ho kai chiang"));
        use.addUserToFacility(new FacilityUser(800, 5, "jian liu"));

        System.out.println("Actual usage: " + use.getActualUsage());
        System.out.println("Actual usage: " + use.getUsageRate());
        use.vacateFacility();

        System.out.println("Actual usage after vacating facility: " + use.getActualUsage());

        System.out.println("Removing unit from building... (current facility size is: " + facility.getSize() + ")");
        facility.removeFacility(units[0]);
        System.out.println("...unit removed (current facility size is: " + facility.getSize() + ")");
        System.out.println("Is facility in use during the open hours? (8am to 5pm)? " + use.isInUseDuringInterval(800, 1700));
        System.out.println("-----------------------DONE-----------------------");
    }
}
