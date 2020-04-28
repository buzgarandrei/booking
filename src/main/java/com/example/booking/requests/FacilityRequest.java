package com.example.booking.requests;

import com.example.booking.utils.FacilityType;

public class FacilityRequest {

    private Long id;
    private String SVG;
    private FacilityType facilityType;
    private String facilityName;

    public FacilityRequest() {
    }

    public FacilityRequest(Long id, String SVG, FacilityType facilityType, String facilityName) {
        this.id = id;
        this.SVG = SVG;
        this.facilityType = facilityType;
        this.facilityName = facilityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSVG() {
        return SVG;
    }

    public void setSVG(String SVG) {
        this.SVG = SVG;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}
