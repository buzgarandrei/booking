package com.example.booking.responses;

public class HotelDescriptionResponse {

    private Long id;
    private String hotelDescriptionType;
    private Long hotelId;
    private Long descriptionId;

    public HotelDescriptionResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelDescriptionType() {
        return hotelDescriptionType;
    }

    public void setHotelDescriptionType(String hotelDescriptionType) {
        this.hotelDescriptionType = hotelDescriptionType;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Long descriptionId) {
        this.descriptionId = descriptionId;
    }
}
