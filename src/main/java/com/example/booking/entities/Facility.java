package com.example.booking.entities;


import com.example.booking.utils.FacilityType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facility")
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "svg")
    private String SVG;

    @Column(name = "facility_type")
    @Enumerated(EnumType.STRING)
    private FacilityType facilityType;

    @Column(name = "facility_name")
    private String facilityName;


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "facility_descriptions",
                joinColumns = @JoinColumn(name = "id_facility"),
                inverseJoinColumns = @JoinColumn(name = "id_description"))
    private List<Description> descriptionList = new ArrayList<>();

    @ManyToMany(mappedBy = "facilityList", cascade = CascadeType.ALL)
    private List<Room> roomList = new ArrayList<>();

    @ManyToMany(mappedBy = "hotelFacilityList")
    private List<Hotel> hotelList = new ArrayList<>();

/*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hotel_facility",
                joinColumns = @JoinColumn(name = "facility_id"),
                inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    private List<Hotel> hotelList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name =  "room_facility",
                joinColumns = @JoinColumn(name = "facility_id"),
                inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<Room> roomList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offer_facility",
               joinColumns = @JoinColumn(name = "facility_id"),
               inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private List<Offer> offerList;
*/

    public Facility() {
    }

    public Facility(String SVG, FacilityType facilityType, String facilityName, List<Description> descriptionList, List<Room> roomList, List<Hotel> hotelList) {
        this.SVG = SVG;
        this.facilityType = facilityType;
        this.facilityName = facilityName;
        this.descriptionList = descriptionList;
        this.roomList = roomList;
        this.hotelList = hotelList;
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

    public List<Description> getDescriptionList() {
        return descriptionList;
    }

    public void setDescriptionList(List<Description> descriptionList) {
        this.descriptionList = descriptionList;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }
}
