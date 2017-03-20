/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

/**
 *
 * @author Nathnael
 */
public interface IFacilityBudget {

    void setOperatingBudget(double value);

    void setSavings(double value);

    double getOperatingBudget();

    double getSavings();

    @Override
    String toString();

}
