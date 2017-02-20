package Model.Facade;

import Model.Facility.IFacility;
import Model.FacilityMaintenance.FacilityMaintenance;
import Model.FacilityMaintenance.MaintenanceOrder;
import Model.FacilityMaintenance.MaintenanceRequest;

import java.util.HashMap;

/**
 * Created by Nathnael on 2/19/2017.
 */
public class FacilityMaintenanceConcrete implements FacilityMaintenanceFacade {
    IFacility facility;

    public FacilityMaintenanceConcrete(IFacility facility){
        this.facility = facility;
        //provide input
    }
    @Override
    public void makeFacilityMaintRequest() {
        IFacility scheduler = new Requester("Chong chong xi");
        facility.accept(scheduler);

    }

    @Override
    public void scheduleMaintenance() {
        IFacility scheduler = new Scheduler("John Smith");
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
        return facility.getMaintenance().getFacillityDownTime();

    }

    @Override
    public String listMaintRequests() {
        String output = "";
        for(MaintenanceRequest l: facility.getMaintenance().getRequestQueue()){
            s+=  "A problem of  " + l.getProblem() + " requested by " + l.getMaintenanceRequester() + " is under review";
            s+= "\n";

        }
        return output;

    }

    @Override
    public String listMaintenance() {
        String output = "";
        for(MaintenanceOrder l: facility.getMaintenance().getLog().getLogs()){
            s+=  "A problem of  " + l.getRequest().getProblem() + " requested by " + l.getRequest().getMaintenanceRequester() + " costs " + l.getDollarAmount();
            s+= "\n";

        }
        return output;
    }

    @Override
    public String listFacilityProblems() {
        HashMap<String,Integer> problemOccurences = new HashMap<>();
        for(MaintenanceOrder l: facility.getMaintenance().getLog().getLogs()){
            if(problemOccurences.containsKey(l.getRequest().getProblem())){
                problemOccurences.put(l.getRequest().getProblem(),problemOccurences.get(l.getRequest().getProblem())++);
            }else{
                problemOccurences.put(l.getRequest().getProblem(),1);
            }

        }
        String output = "";
        for(String keys : problemOccurences.keySet()){
            output+= "Problem: " + keys + " ||| Occurences: " + problemOccurences.get(keys);
            output+="\n";

        }
        return output;
    }
}
