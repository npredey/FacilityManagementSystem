/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.MaintenanceLog;
import com.OfficeBuilding.FacilityUse.FacilityUse;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.IFacilityInspection;
import com.OfficeBuilding.Inspection.InspectionLog;
import com.OfficeBuilding.Inspection.InspectionLogInterface;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author nickpredey
 */
public class Unit implements IFacility {

    private IfacilityDetail detail;
    private IFacilityMaintenance maintenance;
    private IFacilityInspection inspection;
    private IFacilityUse usage;
    private InspectionLogInterface inspectionLog;

    public Unit() {
//        this.detail = detail;
//        this.maintenance = new FacilityMaintenance();
//        this.inspection = new FacilityInspection();
//        usage = new FacilityUse(800, 1700);
    }

    @Override
    public IFacilityUse getUsage() {
        return usage;
    }

    public void setUsage(IFacilityUse usage) {
        this.usage = usage;
    }

    public InspectionLogInterface getInspectionLog() {
        return inspectionLog;
    }

    public void setInspectionLog(InspectionLogInterface inspectionLog) {
        this.inspectionLog = inspectionLog;
    }

    private void addNewUnitDetail(IfacilityDetail d) {
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
    public IfacilityDetail getFacilityDetail() {
        return detail;
    }

    @Override
    public void addNewDetail(IfacilityDetail anyDetail) {
        addNewUnitDetail(detail);
    }

    @Override
    public void accept(IFacilityDomain domain) {
        domain.visitUnit(this);
    }

    @Override
    public IFacilityMaintenance getMaintenance() {
        return maintenance;
    }

    public IfacilityDetail getDetail() {
        return detail;
    }

    public void setDetail(IfacilityDetail detail) {
        this.detail = detail;
    }

    @Override
    public IFacilityInspection getInspection() {
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
    public InspectionLogInterface getInspections() {
        return inspectionLog;

    }

    @Override
    public int getUserNumber() {
        int size = usage.getActualUsage();

        return size;
    }

    @Override
    public int requestAvailableCapacity() {
        int availableCapacity = getCapacity() - getUserNumber();
        return availableCapacity;
    }

    @Override
    public IfacilityDetail getFacilityInformation() {
        return detail;
    }

    @Override
    public String listFacilities() {
        String f = "";

        f += "Facility id: " + detail.getFacilityID() + " ||| Capacity:  " + detail.getCapacity();
        f += "\n";

        return f;
    }

}
