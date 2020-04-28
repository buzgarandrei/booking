package com.example.booking.requests;

public class RoomBedListRequest {

    private Long id;
    private int noOfBeds;
    private Long roomId;
    private Long bedTypeId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getBedTypeId() {
        return bedTypeId;
    }

    public void setBedTypeId(Long bedTypeId) {
        this.bedTypeId = bedTypeId;
    }
}
