package com.example.booking.repositories;

import com.example.booking.entities.BedType;
import com.example.booking.entities.Room;
import com.example.booking.entities.RoomBedList;
import com.example.booking.requests.RoomBedListRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoomBedListRepositoryImpl implements RoomBedListRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<RoomBedList> getListOfAllBeds() {
        Query query = entityManager.createQuery("select list from RoomBedList list ", RoomBedList.class);
        List<RoomBedList> resultList = query.getResultList();
        return resultList;
    }

    @Override
    @Transactional
    public StateResponse addBedToARoom(RoomBedListRequest request) {
        StateResponse stateResponse = new StateResponse();
        RoomBedList roomBedList = new RoomBedList();
        Room room = entityManager.find(Room.class, request.getRoomId());
        if(room == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        roomBedList.setRoom(room);
        BedType bedType = entityManager.find(BedType.class,request.getBedTypeId().intValue());
        if (bedType == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        roomBedList.setNoOfBeds(request.getNoOfBeds());

        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateBedOfARoom(RoomBedListRequest request) {
        StateResponse stateResponse = new StateResponse();
        RoomBedList roomBedList = entityManager.find(RoomBedList.class,request.getId());
        Room room = entityManager.find(Room.class, request.getRoomId());
        if(room == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        BedType bedType = entityManager.find(BedType.class, request.getBedTypeId().intValue());
        if(bedType == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        roomBedList.setBedType(bedType);
        roomBedList.setRoom(room);
        if(request.getNoOfBeds() != 0)
            roomBedList.setNoOfBeds(request.getNoOfBeds());

        entityManager.merge(roomBedList);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteBedOfARoom(RequestWithId request) {
        entityManager.remove(entityManager.find(RoomBedList.class, request.getId()));
    }

    @Override
    @Transactional
    public List<RoomBedList> getBedsOfARoom(RequestWithId request) {
        Query query = entityManager
                                    .createQuery("select list from RoomBedList list " +
                                            "where list.room.id = :id",RoomBedList.class)
                                    .setParameter("id",request.getId());
        List<RoomBedList> resultList = query.getResultList();
        return resultList;
    }
}
