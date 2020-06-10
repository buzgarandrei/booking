package com.example.booking.repositories;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Hotel;
import com.example.booking.entities.Price;
import com.example.booking.entities.Room;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.RoomRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomResponse;
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
public class RoomRepositoryImpl implements RoomRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<RoomResponse> getRooms() {

        Query query = entityManager.createQuery("select rooms from Room rooms ", Room.class);
        List<Room> roomList = query.getResultList();
        List<RoomResponse> responseList = new ArrayList<>();

        for (Room room : roomList) {
            RoomResponse response = new RoomResponse();
            response.setId(room.getId());
            response.setIdHotel(room.getHotel().getId());
            response.setNrOfAdults(room.getNrOfAdults());
            response.setNrOfKids(room.getNrOfKids());
            response.setAvailable(room.isAvailable());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    @Transactional
    public StateResponse addRoom(RoomRequest roomRequest) {

        StateResponse stateResponse = new StateResponse();
        if(roomRequest.getNrOfAdults() == 0 || roomRequest.getIdHotel() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Room room = new Room();
        Hotel hotel = entityManager.find(Hotel.class, roomRequest.getIdHotel());
        if(hotel == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        room.setHotel(hotel);
        room.setNrOfKids(roomRequest.getNrOfKids());
        room.setNrOfAdults(roomRequest.getNrOfAdults());
        room.setAvailable(roomRequest.isAvailable().booleanValue());
        entityManager.persist(room);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateRoom(RoomRequest roomRequest) {

        StateResponse stateResponse = new StateResponse();
        Room room = entityManager.find(Room.class, roomRequest.getId());

        if(roomRequest.getIdHotel() != null) {
            Hotel hotel = entityManager.find(Hotel.class, roomRequest.getIdHotel());
            if (hotel == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
            room.setHotel(hotel);
        }
        if(roomRequest.getNrOfAdults() != 0) room.setNrOfAdults(roomRequest.getNrOfAdults());
        if(roomRequest.getNrOfKids() != 0) room.setNrOfKids(roomRequest.getNrOfKids());
        if(roomRequest.isAvailable() != null)
            room.setAvailable(roomRequest.isAvailable());
        entityManager.merge(room);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteRoom(RequestWithId request) {

        Room room = entityManager.find((Room.class), request.getId());
        entityManager.remove(room);
    }

    @Override
    @Transactional
    public StateResponse addRoomFacility(RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        if(request.getId1() == null || request.getId2() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Room room = entityManager.find(Room.class,request.getId1());
        if(room == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Facility facility = entityManager.find(Facility.class,request.getId2());
        if(facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        room.getFacilityList().add(facility);
        entityManager.merge(room);
        stateResponse.setSuccess(true);
        return stateResponse;

    }

    @Override
    @Transactional
    public StateResponse deleteRoomFacility(RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        if(request.getId1() == null || request.getId2() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Room room = entityManager.find(Room.class,request.getId1());
        if(room == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Facility facility = entityManager.find(Facility.class,request.getId2());
        if(facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        room.getFacilityList().remove(facility);
        entityManager.merge(room);
        stateResponse.setSuccess(true);
        return stateResponse;

    }

    @Override
    @Transactional
    public List<Facility> getRoomFacilities(RequestWithId request) {
        Query query = entityManager.createQuery("select room.facilityList from Room room " +
                "where room.id = :id", Collection.class)
                .setParameter("id" ,request.getId());
        List<Facility> resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public List<Price> getPricesOfRoom(RequestWithId request) {
        List<Price> priceList = entityManager.createQuery("select distinct price from Price price where price.room.id = :id order by price.id",Price.class)
                .setParameter("id",request.getId()).getResultList();
        return priceList;
    }

}
