/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
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
    private FacilityInspection inspection;

    /**
     *
     * @param units
     */
    public Building(final Unit... units) {
        facilities = Arrays.asList(units);
        this.detail = new FacilityDetail(-1, getCapacity(), null, null);
        this.inspectionLog = new InspectionLog();

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
    public void accept(IFacilityDomain domain){
        domain.visitBuilding(this);
    }

    @Override
    public String toString() {
        return "Building{" + " detail=" + detail.toString() + '}';
    }

}
