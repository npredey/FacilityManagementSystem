/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityUse.FacilityUse;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.InspectionLog;
import com.OfficeBuilding.Inspection.InspectorVisitor;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author nickpredey
 */
public class Building implements IFacility {

    private FacilityMaintenance maintenance;
    private FacilityDetail detail;
    public List<IFacility> facilities;
    public InspectionLog inspectionLog;

    @Override
    public IFacilityUse getUsage() {
        return usage;
    }

    private FacilityInspection inspection;
    private IFacilityUse usage;

    /**
     *
     * @param units
     */
    public Building(final Unit... units) {
        facilities = Arrays.asList(units);
        this.detail = new FacilityDetail(-1, getCapacity(), null, null);
        this.inspectionLog = new InspectionLog();
        usage = new FacilityUse("8:00", "5:00");

    }

    public InspectionLog getInspectionLog() {
        return inspectionLog;
    }

    public void setInspectionLog(InspectionLog inspectionLog) {
        this.inspectionLog = inspectionLog;
    }

    private void addNewFacilityDetail(FacilityDetail d) {
        detail = d;
    }

    @Override
    public FacilityMaintenance getMaintenance() {
        return maintenance;
    }

    public List<IFacility> getFacilities() {
        return Collections.unmodifiableList(facilities);
    }

    @Override
    public void addFacility(IFacility anyFacility) {
        facilities.add(anyFacility);
    }

    @Override
    public void removeFacility(IFacility anyFacility) {
        facilities.remove(anyFacility);
    }

    @Override
    public int getSize() {
        //separate out to visitor
        int size = 0;
        for (IFacility facility : facilities) {
            size += facility.getSize();
        }
        return size;
    }

    @Override
    public final int getCapacity() {
        //separate out into visitor
        int cap = 0;
        for (IFacility facility : facilities) {
            cap += facility.getCapacity();
        }

        return cap;
    }

    @Override
    public FacilityDetail getFacilityDetail() {
        return detail;
    }

    @Override
    public FacilityInspection getInspection() {
        return inspection;
    }

    @Override
    public void addNewDetail(FacilityDetail anyDetail) {
        addNewFacilityDetail(anyDetail);
    }

    public FacilityDetail getDetail() {
        return detail;
    }

    @Override
    public void accept(IFacilityDomain domain) {
        domain.visitBuilding(this);
    }

    @Override
    public String toString() {
        return "Building{" + " detail=" + detail.toString() + '}';
    }

    @Override
    public InspectionLog getInspections() {
        return inspectionLog;

    }

    @Override
    public int getUserNumber() {
        int size = 0;
        for (IFacility facility : facilities) {
            size += facility.getUsage().getActualUsage();
        }
        return size;
    }

    @Override
    public int requestAvailableCapacity() {
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
        for (IFacility fs : facilities) {
            f += "Facility id: " + fs.getFacilityDetail().getFacilityID() + " ||| Capacity:  " + fs.getFacilityDetail().getCapacity();
            f += "\n";
        }
        return f;
    }

}
