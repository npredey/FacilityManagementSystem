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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nickpredey
 */
public class Building implements IFacility {

    private FacilityMaintenance maintenance;
    private FacilityDetail detail;
    public List<IFacility> facilities;
    public InspectionLog inspectionLog;

    public List<IFacility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<IFacility> facilities) {
        this.facilities = facilities;
    }

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
        facilities = new ArrayList<>(Arrays.asList(units));
        this.detail = new FacilityDetail(-1, 0, null, null);
        getCapacity();
        this.inspectionLog = new InspectionLog();
        this.maintenance = new FacilityMaintenance();
        this.inspection = new FacilityInspection();
        usage = new FacilityUse(800, 1700);

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

    @Override
    public void addFacility(IFacility anyFacility) {
        if ((anyFacility.getCapacity() + getCapacity()) > getCapacity()) {
            try {
                throw new java.lang.Exception("New unit cannot be added due to not enough capacity. "
                        + "We apologize for the inconvenience");
            } catch (Exception ex) {
                Logger.getLogger(Building.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            facilities.add(anyFacility);
        }

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
        getFacilityDetail().setCapacity(cap);
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
