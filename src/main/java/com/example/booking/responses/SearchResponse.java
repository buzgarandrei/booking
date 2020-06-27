package com.example.booking.responses;

import com.example.booking.utils.RoomAvailability;

import java.util.List;

public class SearchResponse {
    private Long idRoom;
    private float total;
    private String roomDescription;
    private List<FacilityResponse> roomFacilities;
    private List<FacilityResponse> hotelFacilities;
    private String startDate;
    private String endDate;
    private String hotelName;
    private String hotelDescription;
    private RoomAvailability roomAvailability;

    public SearchResponse() {
    }

    public SearchResponse(Long idRoom, float total, String roomDescription, List<FacilityResponse> roomFacilities, List<FacilityResponse> hotelFacilities, String startDate, String endDate) {
        this.idRoom = idRoom;
        this.total = total;
        this.roomDescription = roomDescription;
        this.roomFacilities = roomFacilities;
        this.hotelFacilities = hotelFacilities;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Long getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Long idRoom) {
        this.idRoom = idRoom;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getRoomDescription() {
        return roomDescription;
    }

    public void setRoomDescription(String roomDescription) {
        this.roomDescription = roomDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<FacilityResponse> getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(List<FacilityResponse> roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public List<FacilityResponse> getHotelFacilities() {
        return hotelFacilities;
    }

    public void setHotelFacilities(List<FacilityResponse> hotelFacilities) {
        this.hotelFacilities = hotelFacilities;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public RoomAvailability getRoomAvailability() {
        return roomAvailability;
    }

    public void setRoomAvailability(RoomAvailability roomAvailability) {
        this.roomAvailability = roomAvailability;
    }
}
