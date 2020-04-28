package com.example.booking.entities;

import javax.persistence.*;

@Entity
@Table(name = "room_bed_list")
public class RoomBedList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bed_type")
    private BedType bedType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_room")
    private Room room;

    @Column(name = "no_of_beds")
    private int noOfBeds;

    public RoomBedList() {
    }

    public RoomBedList(BedType bedType, Room room, int noOfBeds) {
        this.bedType = bedType;
        this.room = room;
        this.noOfBeds = noOfBeds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNoOfBeds() {
        return noOfBeds;
    }

    public void setNoOfBeds(int noOfBeds) {
        this.noOfBeds = noOfBeds;
    }

    @Override
    public String toString() {
        return "RoomBedList{" +
                "id=" + id +
                ", bedType=" + bedType +
                ", room=" + room +
                ", noOfBeds=" + noOfBeds +
                '}';
    }
}
