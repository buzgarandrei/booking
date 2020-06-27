package com.example.booking.repositories;

import com.example.booking.entities.Description;
import com.example.booking.entities.Hotel;
import com.example.booking.entities.HotelDescription;
import com.example.booking.entities.RoomDescription;
import com.example.booking.requests.HotelDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.HotelDescriptionType;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.net.URL;
import java.util.List;

@Repository
public class HotelDescriptionRepositoryImpl implements HotelDescriptionRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<HotelDescription> getHotelDescriptions() {
        Query query = entityManager.createQuery(" select hd from HotelDescription  hd ", HotelDescription.class);
        List<HotelDescription> resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public StateResponse addHotelDescriptions(HotelDescriptionRequest request) {
        HotelDescription hotelDescription = new HotelDescription();
        StateResponse stateResponse = new StateResponse();
        Hotel hotel = entityManager.find(Hotel.class, request.getHotelId());
       if(hotel == null) {
           stateResponse.setSuccess(false);
           return stateResponse;
       }
        hotelDescription.setHotel(hotel);

        Description description = entityManager.find(Description.class, request.getDescriptionId());
        if(description == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        hotelDescription.setDescription(description);

        hotelDescription.setHotelDescriptionType(HotelDescriptionType.valueOf(request.getHotelDescriptionType()));
        entityManager.persist(hotelDescription);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateHotelDescription(HotelDescriptionRequest request) {
        HotelDescription hotelDescription = entityManager.find(HotelDescription.class, request.getId());
        StateResponse stateResponse = new StateResponse();
        if(request.getDescriptionId() != null) {
            Description description = entityManager.find(Description.class, request.getDescriptionId());
            if(description == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
            hotelDescription.setDescription(description);
        }
        if(request.getHotelId() != null) {
                Hotel hotel = entityManager.find(Hotel.class, request.getHotelId());
                if(hotel == null) {
                    stateResponse.setSuccess(false);
                    return stateResponse;
                }
                hotelDescription.setHotel(hotel);
            }
        if(request.getHotelDescriptionType() != null)
            hotelDescription.setHotelDescriptionType(HotelDescriptionType.valueOf(request.getHotelDescriptionType()));
        stateResponse.setSuccess(true);
        entityManager.merge(hotelDescription);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteHotelDescription(RequestWithId request) {
        entityManager.remove(entityManager.find(HotelDescription.class,request.getId()));
    }

    @Override
    @Transactional
    public List<HotelDescription> getDescriptionsOfAHotel(RequestWithId request) {
        Query query = entityManager
                .createQuery("select d from HotelDescription d where d.hotel.id = :id", HotelDescription.class)
                .setParameter("id",request.getId());
        List<HotelDescription> resultList = query.getResultList();
        return resultList;

    }
}
