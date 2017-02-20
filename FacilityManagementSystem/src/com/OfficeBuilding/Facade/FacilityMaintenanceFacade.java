package com.OfficeBuilding.Facade;

/**
 * Created by Nathnael on 2/19/2017. Maintenance facade interface so that the
 * maintenance can be performed on the facilities
 */
public interface FacilityMaintenanceFacade {

    /**
     * Makes a maintenance request for a facility
     */
    void makeFacilityMaintRequest();

    /**
     * Schedules a maintenance request for a facility
     */
    void scheduleMaintenance();

    /**
     * Calculates the maintenance cost for a facility
     *
     * @return maintenance cost
     */
    double calculateMaintenanceCostForFacility();

    double calcProblemRateForFacility();

    double calcDownTimeForFacility();

    String listMaintRequests();

    String listMaintenance();

    String listFacilityProblems();
}
