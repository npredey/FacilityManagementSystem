/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.Inspection;

import java.util.Date;

/**
 *
 * @author Nathnael
 */
public interface InspectionFormInterface {
    void setInspectionDate(Date value);

    void setInspectorID(int value);

    void setInspectionNotes(String value);

    Date getInspectionDate();

    int getInspectorID();

    String getInspectionNotes();

    String toString();
    
}
