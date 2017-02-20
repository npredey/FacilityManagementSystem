package Model.Facade;

/**
 * Created by Nathnael on 2/19/2017.
 */
public interface FacilityMaintenanceFacade {
    void makeFacilityMaintRequest();
    void scheduleMaintenance();
    double calculateMaintenanceCostForFacility();
    double calcProblemRateForFacility();
    double calcDownTimeForFacility();
    String listMaintRequests();
    String listMaintenance();
    String listFacilityProblems();
}
