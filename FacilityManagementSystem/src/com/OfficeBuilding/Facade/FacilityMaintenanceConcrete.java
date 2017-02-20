package com.OfficeBuilding.Facade;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.Domain.Requester;
import com.OfficeBuilding.Domain.Staff;
import com.OfficeBuilding.facility.IFacility;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceOrder;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceRequest;

import java.util.HashMap;

/**
 * Created by Nathnael on 2/19/2017. Concrete maintenance class
 */
public class FacilityMaintenanceConcrete implements FacilityMaintenanceFacade {

    IFacility facility;

    public FacilityMaintenanceConcrete(IFacility facility) {
        this.facility = facility;
        //provide input
    }

    @Override
    public void makeFacilityMaintRequest() {
        IFacilityDomain requester = new Requester("Chong chong xi");
        facility.accept(requester);

    }

    @Override
    public void scheduleMaintenance() {
        IFacilityDomain scheduler = new Staff("John Smith");
        facility.accept(scheduler);
    }

    @Override
    public double calculateMaintenanceCostForFacility() {
        return facility.getMaintenance().getMaintenanceCost();
    }

    @Override
    public double calcProblemRateForFacility() {
        return facility.getMaintenance().calcFacilityProblemRate();

    }

    @Override
    public double calcDownTimeForFacility() {
        return facility.getMaintenance().getFacilityDownTime();

    }

    @Override
    public String listMaintRequests() {
        String output = "";
        for (MaintenanceRequest l : facility.getMaintenance().getRequestQueue()) {
            output += "A problem of  " + l.getProblem() + " requested by " + l.getMaintenanceRequester() + " is under review";
            output += "\n";

        }
        return output;

    }

    @Override
    public String listMaintenance() {
        String output = "";
        for (MaintenanceOrder l : facility.getMaintenance().getLog().getLogs()) {
            output += "A problem of  " + l.getRequest().getProblem() + " requested by " + l.getRequest().getMaintenanceRequester() + " costs " + l.getCost().getDollarAmount();
            output += "\n";

        }
        return output;
    }

    @Override
    public String listFacilityProblems() {
        HashMap<String, Integer> problemOccurences = new HashMap<>();
        for (MaintenanceOrder l : facility.getMaintenance().getLog().getLogs()) {
            if (problemOccurences.containsKey(l.getRequest().getProblem())) {
                problemOccurences.put(l.getRequest().getProblem(), problemOccurences.get(l.getRequest().getProblem()) + 1);
            } else {
                problemOccurences.put(l.getRequest().getProblem(), 1);
            }

        }
        String output = "";
        for (String keys : problemOccurences.keySet()) {
            output += "Problem: " + keys + " ||| Occurences: " + problemOccurences.get(keys);
            output += "\n";

        }
        return output;
    }
}
