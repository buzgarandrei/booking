package com.example.booking.requests;

public class HotelRequest {

    private Long id;
    private String name;
    private String city;
    private Long idRegion;

    public HotelRequest() {
    }

    public HotelRequest(Long id, String name, String city, Long idRegion) {
        this.id = id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
