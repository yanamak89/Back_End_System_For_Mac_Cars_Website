package com.udacity.maccars.vehiclesapi.domains;

import com.sun.istack.NotNull;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

/**
 * Stores information about a given location
 */
@Embeddable
public class Location {

    @NotNull
    private Double lat;

    @NotNull
    private Double lon;

    @Transient
    private String address;

    @Transient
    private String city;

    @Transient
    private String state;

    @Transient
    private String zip;

    public Location() {
    }

    public Location(Double lat, Double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }
}