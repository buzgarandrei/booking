package com.example.booking.services;

import com.example.booking.entities.Offer;
import com.example.booking.repositories.OfferRepository;
import com.example.booking.requests.OfferRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.OfferResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    OfferRepository offerRepository;

    @Override
    public List<OfferResponse> getOffers() {

        List<Offer> offerList = offerRepository.getOffers();
        List<OfferResponse> responseList = new ArrayList<>();
        for (Offer offer : offerList) {
            OfferResponse response = new OfferResponse();
            response.setId(offer.getId());
            response.setStartDate(offer.getStartDate().toString());
            response.setEndDate(offer.getEndDate().toString());
            response.setPrice(offer.getPrice());
            response.setIdRoom(offer.getRoom().getId());
            if(offer.getUser() != null)
                response.setIdUser(offer.getUser().getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public StateResponse addOffer(OfferRequest request) throws ParseException {
        return offerRepository.addOffer(request);
    }

    @Override
    public StateResponse updateOffer(OfferRequest request) throws ParseException {
        return offerRepository.updateOffer(request);
    }

    @Override
    public void deleteOffer(RequestWithId request) {
        offerRepository.deleteOffer(request);
    }
}
