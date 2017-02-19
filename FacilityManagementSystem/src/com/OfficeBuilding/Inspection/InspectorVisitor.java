package com.OfficeBuilding.Inspection;

import com.OfficeBuilding.facility.Building;
import com.OfficeBuilding.facility.Unit;

/**
 * Created by Nathnael on 2/18/2017.
 */
public interface InspectorVisitor {

    void inspectBuilding(Building build);

    void inspectUnit(Unit unit);
}
