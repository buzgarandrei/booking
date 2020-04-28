package com.example.booking.entities;

import com.example.booking.utils.OfferDescriptionType;

import javax.persistence.*;

@Entity
@Table(name = "offer_description")
public class OfferDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_offer_description_type")
    @Enumerated(EnumType.STRING)
    private OfferDescriptionType offerDescriptionType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_description")
    private Description description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_offer")
    private Offer offer;

    public OfferDescription() {
    }

    public OfferDescription(OfferDescriptionType offerDescriptionType, Description description, Offer offer) {
        this.offerDescriptionType = offerDescriptionType;
        this.description = description;
        this.offer = offer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OfferDescriptionType getOfferDescriptionType() {
        return offerDescriptionType;
    }

    public void setOfferDescriptionType(OfferDescriptionType offerDescriptionType) {
        this.offerDescriptionType = offerDescriptionType;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}
