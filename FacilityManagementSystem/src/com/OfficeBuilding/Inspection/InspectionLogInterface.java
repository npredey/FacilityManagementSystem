/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathnael
 */
public interface InspectionLogInterface {

    public void setInspections(List<InspectionFormInterface> value);

    public List<InspectionFormInterface> getInspections();

    public void addForm(InspectionFormInterface form);

}
