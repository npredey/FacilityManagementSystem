package com.View;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.Facade.FacilityMaintenanceFacade;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Unit;
import java.text.ParseException;
import UtilityFunctions.UtilFunctions;
import com.OfficeBuilding.FacilityUse.IFacilityUser;
import com.OfficeBuilding.facility.IFacilityBudget;
import com.OfficeBuilding.facility.ILocation;
import com.OfficeBuilding.facility.IfacilityDetail;
import org.springframework.context.ApplicationContext;

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
        ApplicationContext context = UtilFunctions.getApplicationContext();

        ILocation facilityLocation = (ILocation) context.getBean("location");
        facilityLocation.setCity(testCity);
        facilityLocation.setCountry(testCountry);
        facilityLocation.setState(testState);
        facilityLocation.setStreetName(testStreetName);
        facilityLocation.setStreetNumber(testStreetNumber);
        facilityLocation.setZipCode(testZipCode);

        IFacilityBudget facilityBudgetBuilding = (IFacilityBudget) context.getBean("facilityBudget");
        facilityBudgetBuilding.setOperatingBudget(testOperatingBudget0);
        facilityBudgetBuilding.setSavings(testSavings0);
        //new FacilityBudget(testSavings0, testOperatingBudget0);

        IFacilityBudget facilityBudgetUnit1 = (IFacilityBudget) context.getBean("facilityBudget");
        facilityBudgetBuilding.setOperatingBudget(testOperatingBudget1);
        facilityBudgetBuilding.setSavings(testSavings1);

        IFacilityBudget facilityBudgetUnit2 = (IFacilityBudget) context.getBean("facilityBudget");
        facilityBudgetBuilding.setOperatingBudget(testOperatingBudget2);
        facilityBudgetBuilding.setSavings(testSavings2);

        IFacilityBudget facilityBudgetNewUnit = (IFacilityBudget) context.getBean("facilityBudget");
        facilityBudgetBuilding.setOperatingBudget(testOperatingBudget3);
        facilityBudgetBuilding.setSavings(testSavings3);

        IfacilityDetail detailDemoBuilding = (IfacilityDetail) context.getBean("facilityDetail");
        detailDemoBuilding.setAddress(facilityLocation);
        detailDemoBuilding.setCapacity(-1);
        detailDemoBuilding.setFacilityBudget(facilityBudgetBuilding);
        detailDemoBuilding.setFacilityID(0);

        IfacilityDetail detailDemoUnit1 = (IfacilityDetail) context.getBean("facilityDetail");
        detailDemoBuilding.setAddress(facilityLocation);
        detailDemoBuilding.setCapacity(capacityUnit1);
        detailDemoBuilding.setFacilityBudget(facilityBudgetUnit1);
        detailDemoBuilding.setFacilityID(1);

        IfacilityDetail detailDemoUnit2 = (IfacilityDetail) context.getBean("facilityDetail");
        detailDemoBuilding.setAddress(facilityLocation);
        detailDemoBuilding.setCapacity(capacityUnit2);
        detailDemoBuilding.setFacilityBudget(facilityBudgetUnit2);
        detailDemoBuilding.setFacilityID(2);

        IfacilityDetail detailTestNewUnit = (IfacilityDetail) context.getBean("facilityDetail");
        detailDemoBuilding.setAddress(facilityLocation);
        detailDemoBuilding.setCapacity(capacityUnit3);
        detailDemoBuilding.setFacilityBudget(facilityBudgetNewUnit);
        detailDemoBuilding.setFacilityID(3);
        //FacilityDetail detailTestNewUnit = new FacilityDetail(3, capacityUnit3, facilityBudgetNewUnit, facilityLocation);

        Unit unit1 = ((Unit) context.getBean("unit"));
        Unit unit2 = (Unit) context.getBean("unit");
        unit1.addNewDetail(detailDemoUnit1);
        unit2.addNewDetail(detailDemoUnit2);
        //Unit[] units = {unit1,unit2 /*new Unit(detailDemoUnit2)*/};
        IFacility facility = (IFacility) context.getBean("facility");
        facility.addFacility(unit1);//new Building(units);
        facility.addFacility(unit2);
        facility.addNewDetail(detailDemoBuilding);

        System.out.println("Initial capacity (should be 250): " + facility.getCapacity());
        System.out.println("Requesting available capacity...: " + facility.requestAvailableCapacity());
        System.out.println("Printing facility information: " + facility.getFacilityInformation());
        System.out.println("List of facilities: \n" + facility.listFacilities());

        IFacilityDomain staff = (IFacilityDomain) context.getBean("staff");
        staff.setStaffName(testStaffName);//;new Staff(testStaffName);
        IFacilityUse facilityUse = facility.getUsage();
        facilityUse.setStartTime(900);
        facilityUse.setEndTime(1900);//new FacilityUse(900, 1900);

        IFacility newUnit = (IFacility) context.getBean("unit");
        newUnit.addNewDetail(detailTestNewUnit);//;new Unit(detailTestNewUnit);
        facility.addFacility(newUnit);
        System.out.println("Capacity after new unit (new unit cannot be added): " + facility.getCapacity());

        //create a Facility Domain
        //create an inspector object
        //create a FacilityUse Object
        //Call the methods in the interface
        //test for inspection class
        FacilityMaintenanceFacade maintenance = (FacilityMaintenanceFacade) context.getBean("facilityMaintenanceConcrete");
        maintenance.setFacility(facility);
        //new FacilityMaintenanceConcrete(facility);
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
        IFacilityDomain inspector = (IFacilityDomain) context.getBean("inspectorDomain");
        inspector.setStaffName("Mr. X");// new Inspector(12);
        facility.accept(inspector);
        facility.accept(inspector);
        facility.accept(inspector);

        facility.getInspections().getInspections().stream().forEach((il) -> {
            System.out.println("Inspector ID: " + il.getInspectorID());
        });

        //call the rest of the methods
        //test for facility use
        IFacilityUse use = facility.getUsage();//new FacilityUse(800, 1700);

        IFacilityUser user1 = (IFacilityUser) context.getBean("facilityUser");
        user1.setUserID(1);
        user1.setName("jorge castro");
        user1.setEntryTime(800);

        IFacilityUser user2 = (IFacilityUser) context.getBean("facilityUser");
        user1.setUserID(2);
        user1.setName("james miller");
        user1.setEntryTime(800);
        IFacilityUser user3 = (IFacilityUser) context.getBean("facilityUser");
        user1.setUserID(3);
        user1.setName("Yi Lee");
        user1.setEntryTime(800);
        IFacilityUser user4 = (IFacilityUser) context.getBean("facilityUser");
        user1.setUserID(4);
        user1.setName("ho kai chiang");
        user1.setEntryTime(800);
        IFacilityUser user5 = (IFacilityUser) context.getBean("facilityUser");
        user1.setUserID(5);
        user1.setName("jian liu");
        user1.setEntryTime(800);

        use.addUserToFacility(user1);
        use.addUserToFacility(user2);
        use.addUserToFacility(user3);
        use.addUserToFacility(user4);
        use.addUserToFacility(user5);

        System.out.println("Actual usage: " + use.getActualUsage());
        System.out.println("Actual usage: " + use.getUsageRate());
        use.vacateFacility();

        System.out.println("Actual usage after vacating facility: " + use.getActualUsage());

        System.out.println("Removing unit from building... (current facility size is: " + facility.getSize() + ")");
        facility.removeFacility(unit1);
        System.out.println("...unit removed (current facility size is: " + facility.getSize() + ")");
        System.out.println("Is facility in use during the open hours? (8am to 5pm)? " + use.isInUseDuringInterval(800, 1700));
        System.out.println("-----------------------DONE-----------------------");
    }
}
