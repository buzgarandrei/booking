package com.example.booking.responses;

import java.util.ArrayList;
import java.util.List;

public class HotelResponse {

    private String name;
    private String city;
    private Long idRegion;

    public HotelResponse() {
    }

    public HotelResponse(String name, String city, Long idRegion) {
        this.name = name;
        this.city = city;
        this.idRegion = idRegion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Long getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Long idRegion) {
        this.idRegion = idRegion;
    }
}
