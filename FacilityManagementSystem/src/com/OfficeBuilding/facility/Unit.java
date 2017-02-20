/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.InspectorVisitor;
import java.util.Objects;

/**
 *
 * @author nickpredey
 */
public class Unit implements IFacility {

    private FacilityDetail detail;
    private FacilityMaintenance maintenance;
    private FacilityInspection inspection;
    private IfacilityUse usage;

    public Unit(FacilityDetail detail) {
        this.detail = detail;
        this.maintenance = new FacilityMaintenance();
        this.inspection = new FacilityInspection();
        usage = new FacilityUse("8:00", "5:00");
    }

    private void addNewUnitDetail(FacilityDetail d) {
        detail = d;
    }

    @Override
    public void addFacility(IFacility anyFacility) {
        anyFacility.addFacility(this);
    }

    @Override
    public void removeFacility(IFacility anyFacility) {
        anyFacility.removeFacility(this);
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return detail.getCapacity();
    }

    @Override
    public FacilityDetail getFacilityDetail() {
        return detail;
    }

    @Override
    public void addNewDetail(FacilityDetail anyDetail) {
        addNewUnitDetail(detail);
    }

    @Override
    public void accept(IFacilityDomain domain){
        domain.visitUnit(this);
    }

    @Override
    public FacilityMaintenance getMaintenance() {
        return maintenance;
    }

    public FacilityDetail getDetail() {
        return detail;
    }

    public void setDetail(FacilityDetail detail) {
        this.detail = detail;
    }

    @Override
    public FacilityInspection getInspection() {
        return inspection;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.detail);
        hash = 59 * hash + Objects.hashCode(this.maintenance);
        hash = 59 * hash + Objects.hashCode(this.inspection);
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
        final Unit other = (Unit) obj;
        if (!Objects.equals(this.detail, other.detail)) {
            return false;
        }
        if (!Objects.equals(this.maintenance, other.maintenance)) {
            return false;
        }
        if (!Objects.equals(this.inspection, other.inspection)) {
            return false;
        }
        return true;
    }

    @Override
    public InspectionLog getInspections() {
        return facility.getInspection().getLog();

    }
    public int getUserNumber(){
        int size = usage.getActualUsage();

        return size;
    }

    @Override
    public int requestAvailableCapacity(){
        int availableCapacity = getCapacity() - getUserNumber();
        return availableCapacity;
    }

    @Override
    public FacilityDetail getFacilityInformation() {
        return detail;
    }

    @Override
    public String listFacilities() {
        String f = "";

            f+= "Facility id: "detail.getFacilityID() + " ||| Capacity:  "+detail.getCapacity();
            f+="\n";

        return f;
    }

}
