package com.View;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.Domain.Staff;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.FacilityUse.FacilityUse;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.FacilityBudget;
import com.OfficeBuilding.facility.FacilityDetail;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.facility.Location;
import com.OfficeBuilding.facility.Unit;

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

    public static void main(String[] args) {
        MaintenanceLog maintenanceLog = new MaintenanceLog();
        Location facilityLocation = new Location(testStreetName, testStreetNumber,
                testCity, testState, testZipCode, testCountry);

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

        IFacilityDomain staff = new Staff(testStaffName);
        IFacilityUse facilityUse = new FacilityUse("9:00:00", "19:00:00", facility);

        IFacility newUnit = new Unit(detailTestNewUnit);
        facility.addFacility(newUnit);
        System.out.println("Capacity after new unit (should be 550): " + facility.getCapacity());
        System.out.println("-----------------------DONE-----------------------");
        //create a Facility Domain
        //create an inspector object
        //create a FacilityUse Object
        //Call the methods in the interface
    }
}
