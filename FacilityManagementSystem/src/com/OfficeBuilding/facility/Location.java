/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OfficeBuilding.facility;

import java.util.Objects;

/**
 *
 * @author nickpredey
 */
public class Location implements ILocation {

    private String streetName;
    private String streetNumber;
    private String city;
    private String state;
    private int zipCode;
    private String country;

    public Location() {
//        this.streetName = streetName;
//        this.streetNumber = streetNumber;
//        this.city = city;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.country = country;
    }

    @Override
    public String getStreetName() {
        return streetName;
    }

    @Override
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String getStreetNumber() {
        return streetNumber;
    }

    @Override
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public int getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String getCountry() {
        return country;
    }

    @Override
    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Location{" + "streetName=" + streetName + ", streetNumber=" + streetNumber + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", country=" + country + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.streetName);
        hash = 67 * hash + Objects.hashCode(this.streetNumber);
        hash = 67 * hash + Objects.hashCode(this.city);
        hash = 67 * hash + Objects.hashCode(this.state);
        hash = 67 * hash + this.zipCode;
        hash = 67 * hash + Objects.hashCode(this.country);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Location other = (Location) obj;
        if (this.zipCode != other.zipCode) {
            return false;
        }
        if (!Objects.equals(this.streetName, other.streetName)) {
            return false;
        }
        if (!Objects.equals(this.streetNumber, other.streetNumber)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.state, other.state)) {
            return false;
        }
        if (!Objects.equals(this.country, other.country)) {
            return false;
        }
        return true;
    }

}
