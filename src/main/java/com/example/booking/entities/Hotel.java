package com.example.booking.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hotels")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String city;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE }, fetch = FetchType.LAZY)
    @JoinTable(name = "hotel_facilities",
                joinColumns = @JoinColumn(name = "id_hotel"),
                inverseJoinColumns = @JoinColumn(name = "id_facility"))
    private List<Facility> hotelFacilityList = new ArrayList<>();

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Hotel() {
    }

    public Hotel(String name, String city, List<Facility> hotelFacilityList) {
        this.name = name;
        this.city = city;
        this.hotelFacilityList = hotelFacilityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Facility> getHotelFacilityList() {
        return hotelFacilityList;
    }

    public void setHotelFacilityList(List<Facility> hotelFacilityList) {
        this.hotelFacilityList = hotelFacilityList;
    }


    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", hotelFacilityList=" + hotelFacilityList +
                '}';
    }
}
