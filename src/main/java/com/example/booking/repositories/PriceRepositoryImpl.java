package com.example.booking.repositories;

import com.example.booking.entities.Price;
import com.example.booking.entities.Room;
import com.example.booking.requests.PriceRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.PriceResponse;
import com.example.booking.utils.StateResponse;
import com.example.booking.utils.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PriceRepositoryImpl implements PriceRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<PriceResponse> getPrices() {

        Query query = entityManager.createQuery("select prices from Price prices", Price.class);
        List<Price> priceList = query.getResultList();
        List<PriceResponse> responseList = new ArrayList<>();

        for (Price price : priceList) {
            PriceResponse response = new PriceResponse();
            response.setAmount(price.getAmount());
            response.setStartDate(price.getStartDate().toString());
            response.setEndDate(price.getEndDate().toString());
            response.setIdRoom(price.getRoom().getId());
            response.setId(price.getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    @Transactional
    public StateResponse addPrice(PriceRequest request) throws ParseException {

        StateResponse stateResponse = new StateResponse();
        if(request.getIdRoom() == null || request.getAmount() == 0 || request.getStartDate() == null || request.getEndDate() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Price price = new Price();
        price.setStartDate(Utils.DATE_FORMAT.parse(request.getStartDate()));
        price.setEndDate(Utils.DATE_FORMAT.parse(request.getEndDate()));
        price.setAmount(request.getAmount());
        Room room = entityManager.find(Room.class, request.getIdRoom());
        if (room == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        price.setRoom(room);

        entityManager.persist(price);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updatePrice(PriceRequest request) throws ParseException {

        StateResponse stateResponse = new StateResponse();
        Price price = entityManager.find(Price.class, request.getId());
        if(request.getStartDate() != null) price.setStartDate(Utils.DATE_FORMAT.parse(request.getStartDate()));
        if(request.getEndDate() != null) price.setEndDate(Utils.DATE_FORMAT.parse(request.getEndDate()));
        if(request.getAmount() != 0) price.setAmount(request.getAmount());
        if(request.getIdRoom() != null) {
            Room room = entityManager.find(Room.class, request.getIdRoom());
            if (room == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
            price.setRoom(room);
        }

        entityManager.merge(price);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deletePrice(RequestWithId request) {

        Price price = entityManager.find(Price.class, request.getId());
        entityManager.remove(price);
    }
}
