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
public interface ILocation {
    public String getStreetName();

    public void setStreetName(String streetName);

    public String getStreetNumber();

    public void setStreetNumber(String streetNumber);

    public String getCity();

    public void setCity(String city);

    public String getState();

    public void setState(String state);

    public int getZipCode();

    public void setZipCode(int zipCode);

    public String getCountry();

    public void setCountry(String country);

    @Override
    public String toString();
    
}
