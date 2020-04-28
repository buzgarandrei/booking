package com.example.booking.repositories;

import com.example.booking.entities.Offer;
import com.example.booking.entities.Room;
import com.example.booking.entities.User;
import com.example.booking.requests.OfferRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;
import com.example.booking.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.List;

@Repository
public class OfferRepositoryImpl implements OfferRepository {

    @Autowired
    EntityManager entityManager;


    @Override
    @Transactional
    public List<Offer> getOffers() {
        Query query = entityManager.createQuery("select offers from Offer offers");
        List<Offer> offers = query.getResultList();
        return offers;
    }

    @Override
    @Transactional
    public StateResponse addOffer(OfferRequest request) throws ParseException {
        StateResponse stateResponse = new StateResponse();
        Offer offer = new Offer();
        if(request.getIdRoom() ==null || request.getPrice() == 0 || request.getStartDate() == null || request.getEndDate() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Room room = entityManager.find(Room.class,request.getIdRoom());
        if(room == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        offer.setRoom(room);
        offer.setStartDate(Utils.DATE_FORMAT.parse(request.getStartDate()));
        offer.setEndDate(Utils.DATE_FORMAT.parse(request.getEndDate()));
        offer.setPrice(request.getPrice());

        entityManager.persist(offer);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateOffer(OfferRequest request) throws ParseException {
        StateResponse stateResponse = new StateResponse();
        Offer offer = entityManager.find(Offer.class,request.getId());
        if(offer == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        if(request.getIdRoom() != null) {
            Room room = entityManager.find(Room.class,request.getIdRoom());
            if(room == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
        }
        if(request.getIdUser() != null) {
            User user = entityManager.find(User.class,request.getIdUser());
            if (user == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
        }
        if(request.getStartDate() != null) offer.setStartDate(Utils.DATE_FORMAT.parse(request.getStartDate()));
        if(request.getEndDate() != null) offer.setEndDate(Utils.DATE_FORMAT.parse(request.getEndDate()));
        if(request.getPrice() != 0) offer.setPrice(request.getPrice());
        entityManager.merge(offer);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteOffer(RequestWithId request) {
        entityManager.remove(entityManager.find(Offer.class,request.getId()));
    }
}
