package com.example.booking.repositories;

import com.example.booking.entities.Offer;
import com.example.booking.requests.OfferRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;

import java.text.ParseException;
import java.util.List;

public interface OfferRepository {
    List<Offer> getOffers();

    StateResponse addOffer(OfferRequest request) throws ParseException;

    StateResponse updateOffer(OfferRequest request) throws ParseException;

    void deleteOffer(RequestWithId request);
}
