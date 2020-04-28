package com.example.booking.responses;

public class RoomDescriptionResponse {

    private Long id;
    private String roomDescriptionType;
    private Long roomId;
    private Long descriptionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomDescriptionType() {
        return roomDescriptionType;
    }

    public void setRoomDescriptionType(String roomDescriptionType) {
        this.roomDescriptionType = roomDescriptionType;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Long getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Long descriptionId) {
        this.descriptionId = descriptionId;
    }
}
