package com.OfficeBuilding.Facade;

import static UtilityFunctions.UtilFunctions.getApplicationContext;
import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceOrder;
import com.OfficeBuilding.FacilityMaintenance.IMaintenanceRequest;
import com.OfficeBuilding.facility.IFacility;

import java.util.HashMap;
import java.util.Objects;
import org.springframework.context.ApplicationContext;

/**
 * Created by Nathnael on 2/19/2017. Concrete maintenance class
 */
public class FacilityMaintenanceConcrete implements FacilityMaintenanceFacade {

    private IFacility facility;
    private HashMap<String, Integer> problemOccurences;

    public FacilityMaintenanceConcrete() {
        //this.facility = facility;
        //provide input
    }

    public HashMap<String, Integer> getProblemOccurences() {
        return problemOccurences;
    }

    public void setProblemOccurences(HashMap<String, Integer> problemOccurences) {
        this.problemOccurences = problemOccurences;
    }

    @Override
    public IFacility getFacility() {
        return facility;
    }

    @Override
    public void setFacility(IFacility facility) {
        this.facility = facility;
    }

    @Override
    public void makeFacilityMaintRequest() {
        ApplicationContext context = getApplicationContext();
        IFacilityDomain requester = (IFacilityDomain) context.getBean("requester");
        requester.setStaffName("Chong chong xi");
        //IFacilityDomain requester = new Requester("Chong chong xi");
        facility.accept(requester);

    }

    @Override
    public void scheduleMaintenance() {
        ApplicationContext context = getApplicationContext();
        IFacilityDomain scheduler = (IFacilityDomain) context.getBean("staff");
        scheduler.setStaffName("John Smith");
        //IFacilityDomain scheduler = new Staff("John Smith");
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
        for (IMaintenanceRequest l : facility.getMaintenance().getRequestQueue()) {
            output += "A problem of  " + l.getProblem() + " requested by " + l.getMaintenanceRequester() + " is under review";
            output += "\n";

        }
        return output;

    }

    @Override
    public String listMaintenance() {
        String output = "";
        for (IMaintenanceOrder l : facility.getMaintenance().getLog().getLogs()) {
            output += "A problem of  " + l.getRequest().getProblem() + " requested by " + l.getRequest().getMaintenanceRequester() + " costs " + l.getCost().getDollarAmount();
            output += "\n";

        }
        return output;
    }

    @Override
    public String listFacilityProblems() {
        for (IMaintenanceOrder l : facility.getMaintenance().getLog().getLogs()) {
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.facility);
        hash = 47 * hash + Objects.hashCode(this.problemOccurences);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FacilityMaintenanceConcrete other = (FacilityMaintenanceConcrete) obj;
        if (!Objects.equals(this.facility, other.facility)) {
            return false;
        }
        if (!Objects.equals(this.problemOccurences, other.problemOccurences)) {
            return false;
        }
        return true;
    }

}
