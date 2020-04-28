package com.example.booking.entities;

import com.example.booking.utils.RoomDescriptionType;

import javax.persistence.*;

@Entity
@Table(name = "room_description")
public class RoomDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_description_type")
    @Enumerated(EnumType.STRING)
    private RoomDescriptionType roomDescriptionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_description")
    private Description description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    private Room room;

    public RoomDescription() {
    }

    public RoomDescription(RoomDescriptionType roomDescriptionType, Description description, Room room) {
        this.roomDescriptionType = roomDescriptionType;
        this.description = description;
        this.room = room;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomDescriptionType getRoomDescriptionType() {
        return roomDescriptionType;
    }

    public void setRoomDescriptionType(RoomDescriptionType roomDescriptionType) {
        this.roomDescriptionType = roomDescriptionType;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
