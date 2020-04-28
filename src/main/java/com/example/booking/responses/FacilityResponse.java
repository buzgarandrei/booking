package com.example.booking.responses;

import com.example.booking.utils.FacilityType;

public class FacilityResponse {
    private Long id;
    private String SVG;
    private FacilityType facilityType;
    private String  facilityName;

    public FacilityResponse() {
    }

    public FacilityResponse(Long id, String SVG, FacilityType facilityType, String facilityName) {
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
