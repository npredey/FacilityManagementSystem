/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

/**
 *
 * @author nickpredey
 */
public class Location {

    private String streetName;
    private String streetNumber;
    private String city;
    private String state;
    private int zipCode;
    private String country;

    public Location(String streetName, String streetNumber, String city, String state,
            int zipCode, String country) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public void setCity(String value) {
        city = value;
    }

    public void setCountry(String value) {
        country = value;
    }

    public void setState(String value) {
        state = value;
    }

    public void setStreetName(String value) {
        streetName = value;
    }

    public void setStreetNumber(String value) {
        streetNumber = value;
    }

    public void setZipCode(int value) {
        zipCode = value;
    }

    public String getCity(String value) {
        return city;
    }

    public String getCountry(String value) {
        return country;
    }

    public String getState(String value) {
        return state;
    }

    public String getStreetName(String value) {
        return streetName;
    }

    public String getStreetNumber(String value) {
        return streetNumber;
    }

    public int getZipCode(int value) {
        return zipCode;
    }
}
