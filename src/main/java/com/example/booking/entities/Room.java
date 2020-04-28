package com.example.booking.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private boolean available;

    @Column(name = "nr_of_adults")
    private int nrOfAdults;

    @Column(name = "nr_of_kids")
    private int nrOfKids;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
    @JoinTable(name =  "room_facility",
            joinColumns = @JoinColumn(name = "id_room"),
            inverseJoinColumns = @JoinColumn(name = "id_facility"))
    private List<Facility> facilityList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public Room() {
    }

    public Room(boolean available, List<Facility> facilityList, int nrOfAdults, int nrOfKids, Hotel hotel) {
        this.available = available;
        this.facilityList = facilityList;
        this.nrOfAdults = nrOfAdults;
        this.nrOfKids = nrOfKids;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }

    public int getNrOfAdults() {
        return nrOfAdults;
    }

    public void setNrOfAdults(int nrOfAdults) {
        this.nrOfAdults = nrOfAdults;
    }

    public int getNrOfKids() {
        return nrOfKids;
    }

    public void setNrOfKids(int nrOfKids) {
        this.nrOfKids = nrOfKids;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", available=" + available +
                ", nrOfAdults=" + nrOfAdults +
                ", nrOfKids=" + nrOfKids +
                ", facilityList=" + facilityList +
                ", hotel=" + hotel +
                '}';
    }
}
