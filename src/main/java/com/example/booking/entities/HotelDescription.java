package com.example.booking.entities;

import com.example.booking.utils.HotelDescriptionType;

import javax.persistence.*;

@Entity
@Table(name = "hotel_description")
public class HotelDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_description_type")
    @Enumerated(EnumType.STRING)
    private HotelDescriptionType hotelDescriptionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_description")
    private Description description;

    //apare id_hotel
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_hotel")
    private Hotel hotel;

    public HotelDescription() {
    }

    public HotelDescription(HotelDescriptionType hotelDescriptionType, Description description, Hotel hotel) {
        this.hotelDescriptionType = hotelDescriptionType;
        this.description = description;
        this.hotel = hotel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HotelDescriptionType getHotelDescriptionType() {
        return hotelDescriptionType;
    }

    public void setHotelDescriptionType(HotelDescriptionType hotelDescriptionType) {
        this.hotelDescriptionType = hotelDescriptionType;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}
