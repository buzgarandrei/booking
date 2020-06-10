package com.example.booking.repositories;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Hotel;
import com.example.booking.entities.Room;
import com.example.booking.entities.User;
import com.example.booking.requests.HotelRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.HotelResponse;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class HotelRepositoryImpl implements HotelRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<HotelResponse> getHotels() {

        Query query = entityManager.createQuery("select hotels from Hotel hotels", Hotel.class);
        List<Hotel> hotels = query.getResultList();
        List<HotelResponse> responseList = new ArrayList<>();

        for (Hotel hotel : hotels) {

            HotelResponse response = new HotelResponse();
            response.setCity(hotel.getCity());
            response.setName(hotel.getName());
            response.setIdUser(hotel.getUser().getId());
            responseList.add(response);
        }
        return responseList;
    }

    @Override
    @Transactional
    public StateResponse addHotel(HotelRequest request) {

        StateResponse stateResponse = new StateResponse();
        User user = entityManager.find(User.class,request.getIdUser());
        if (request.getName() == null || request.getCity() == null || user == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Hotel hotel = new Hotel();
        hotel.setCity(request.getCity());
        hotel.setName(request.getName());
        hotel.setUser(user);

        entityManager.persist(hotel);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateHotel(HotelRequest request) {

        StateResponse stateResponse = new StateResponse();
        Hotel hotel = entityManager.find(Hotel.class, request.getId());

        if (request.getCity() != null) hotel.setCity(request.getCity());
        if (request.getName() != null) hotel.setName(request.getName());
        if (request.getIdUser() != null) {
            User user = new User();
            if (user == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
            hotel.setUser(user);
        }
        entityManager.merge(hotel);
        stateResponse.setSuccess(true);
        return stateResponse;

    }

    @Override
    @Transactional
    public void deleteHotel(RequestWithId request) {

        Hotel hotel = entityManager.find(Hotel.class, request.getId());

        entityManager.remove(hotel);
    }

    @Override
    @Transactional
    public StateResponse addHotelFacility(RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        if (request.getId2() == null || request.getId2() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Hotel hotel = entityManager.find(Hotel.class, request.getId1());
        if (hotel == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }

        Facility facility = entityManager.find(Facility.class, request.getId2());
        if (facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        hotel.getHotelFacilityList().add(facility);
        entityManager.merge(hotel);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse deleteHotelFacility(RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        if (request.getId2() == null || request.getId2() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Hotel hotel = entityManager.find(Hotel.class, request.getId1());
        if (hotel == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Facility facility = entityManager.find(Facility.class, request.getId2());
        if (facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }

        hotel.getHotelFacilityList().remove(facility);
        entityManager.merge(hotel);
        stateResponse.setSuccess(true);
        return stateResponse;

    }

    @Override
    @Transactional
    public List<Facility> getHotelFacilities(RequestWithId request) {

        Query query = entityManager.createQuery("select hotel.hotelFacilityList from Hotel hotel" +
                " where hotel.id = :id ", Collection.class)
                .setParameter("id", request.getId());
        List<Facility> resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public List<Room> getRoomsOfAHotel(RequestWithId request) {

        Query query = entityManager.createQuery("select room from Room room where room.hotel.id = :id", Room.class)
                .setParameter("id", request.getId());
        List<Room> roomList = query.getResultList();
        return roomList;
    }

    @Override
    @Transactional
    public List<HotelResponse> getHotelsOfOwner(RequestWithId requestWithId) {
        if (requestWithId.getId() == null ||  !entityManager.find(User.class, requestWithId.getId()).getRoleEnum().equals(RoleEnum.OWNER))
            return null;
        Query query = entityManager.createQuery("select h from Hotel h where h.user.id = :id", Hotel.class)
                .setParameter("id", requestWithId.getId());
        List<Hotel> hotels = query.getResultList();
        List<HotelResponse> responseList = new ArrayList<>();
        for (Hotel hotel : hotels) {
            HotelResponse response = new HotelResponse();
            response.setCity(hotel.getCity());
            response.setName(hotel.getName());
            response.setId(hotel.getId());
            responseList.add(response);
        }
        return responseList;
    }
}
