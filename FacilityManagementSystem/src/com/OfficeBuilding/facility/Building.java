/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import com.OfficeBuilding.Domain.IFacilityDomain;
import com.OfficeBuilding.FacilityMaintenance.FacilityMaintenance;
import com.OfficeBuilding.FacilityMaintenance.IFacilityMaintenance;
import com.OfficeBuilding.FacilityUse.FacilityUse;
import com.OfficeBuilding.FacilityUse.IFacilityUse;
import com.OfficeBuilding.Inspection.FacilityInspection;
import com.OfficeBuilding.Inspection.IFacilityInspection;
import com.OfficeBuilding.Inspection.InspectionLog;
import com.OfficeBuilding.Inspection.InspectionLogInterface;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nickpredey
 */
public class Building implements IFacility {

    private IFacilityMaintenance maintenance;
    private IfacilityDetail detail;
    private List<IFacility> facilities;
    private InspectionLogInterface inspectionLog;

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

    public Building() {
//        facilities = new ArrayList<>();
//        this.detail = new FacilityDetail();
//        getCapacity();
//        this.inspectionLog = new InspectionLog();
//        this.maintenance = new FacilityMaintenance();
//        this.inspection = new FacilityInspection();
//        usage = new FacilityUse(800, 1700);

    }

    public InspectionLogInterface getInspectionLog() {
        return inspectionLog;
    }

    public void setInspectionLog(InspectionLogInterface inspectionLog) {
        this.inspectionLog = inspectionLog;
    }

    private void addNewFacilityDetail(IfacilityDetail d) {
        detail = d;
    }

    @Override
    public IFacilityMaintenance getMaintenance() {
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
    public IfacilityDetail getFacilityDetail() {
        return detail;
    }

    @Override
    public IFacilityInspection getInspection() {
        return inspection;
    }

    @Override
    public void addNewDetail(IfacilityDetail anyDetail) {
        addNewFacilityDetail(anyDetail);
    }

    public IfacilityDetail getDetail() {
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
    public InspectionLogInterface getInspections() {
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
        return getCapacity() - getUserNumber();
    }

    @Override
    public IfacilityDetail getFacilityInformation() {
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
