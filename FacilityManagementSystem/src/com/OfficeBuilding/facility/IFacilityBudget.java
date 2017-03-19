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
    public void setOperatingBudget(double value);

    public void setSavings(double value);

    public double getOperatingBudget();

    public double getSavings();

    
    public String toString();
    
}
