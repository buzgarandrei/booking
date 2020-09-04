package com.example.booking.entities;

import com.example.booking.utils.Language;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "description")
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(length = 65000, columnDefinition = "LONGTEXT")
    private String text;

    @ManyToMany(mappedBy = "descriptionList")
    List<Facility> facilityList = new ArrayList<>();

/*
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "descriptionList")
    private List<Facility> facilityList;
*/

/*
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "hotels_descriptions",
                joinColumns = @JoinColumn(name = "description_id"),
                inverseJoinColumns = @JoinColumn(name = "hotel_id"))
    private List<Hotel> hotelList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rooms_descriptions",
                joinColumns = @JoinColumn(name = "description_id"),
                inverseJoinColumns = @JoinColumn(name = "room_id"))
    private List<Room> roomList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offers_descriptions",
                joinColumns = @JoinColumn(name = "description_id"),
                inverseJoinColumns = @JoinColumn(name = "offer_id"))
    private List<Offer> offerList;
*/

    public Description() {
    }

    public Description(Language language, String text, List<Facility> facilityList) {
        this.language = language;
        this.text = text;
        this.facilityList = facilityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}

class Sex{
    int age = 18;
}
