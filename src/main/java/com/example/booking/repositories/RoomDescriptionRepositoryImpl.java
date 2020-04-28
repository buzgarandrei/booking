package com.example.booking.repositories;

import com.example.booking.entities.Description;
import com.example.booking.entities.Room;
import com.example.booking.entities.RoomDescription;
import com.example.booking.requests.RoomDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.RoomDescriptionType;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class RoomDescriptionRepositoryImpl implements RoomDescriptionRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<RoomDescription> getRoomDescriptions() {
        Query query = entityManager.createQuery(" select rd from RoomDescription rd ", RoomDescription.class);
        List<RoomDescription> resultList = query.getResultList();
        return  resultList;
    }

    @Override
    @Transactional
    public StateResponse addRoomDescription(RoomDescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        RoomDescription roomDescription = new RoomDescription();
        Description description = entityManager.find(Description.class, request.getDescriptionId());
        if(description == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Room room = entityManager.find(Room.class, request.getRoomId());
        if(room == null) {
            stateResponse.setSuccess(false);
            return  stateResponse;
        }
        roomDescription.setDescription(description);
        roomDescription.setRoom(room);
        roomDescription.setRoomDescriptionType(RoomDescriptionType.valueOf(request.getRoomDescriptionType()));
        entityManager.persist(roomDescription);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateRoomDescription(RoomDescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        RoomDescription roomDescription = entityManager.find(RoomDescription.class, request.getId());
        if(request.getDescriptionId() != null) {
            Description description = entityManager.find(Description.class, request.getDescriptionId());
            if(description == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
            roomDescription.setDescription(description);
        }
        if(request.getRoomId() != null) {
            Room room = entityManager.find(Room.class,request.getRoomId());
            if(room == null) {
                stateResponse.setSuccess(false);
                return stateResponse;
            }
            roomDescription.setRoom(room);
        }
        roomDescription.setRoomDescriptionType(RoomDescriptionType.valueOf(request.getRoomDescriptionType()));

        entityManager.merge(roomDescription);
        stateResponse.setSuccess(true);
        return stateResponse;

    }

    @Override
    @Transactional
    public void deleteRoomDescription(RequestWithId request) {
        entityManager.remove(entityManager.find(RoomDescription.class,request.getId()));
    }

    @Override
    @org.springframework.data.jpa.repository.Query
    public List<RoomDescription> getDescriptionsOfARoom(RequestWithId request) {
        Query query = entityManager.createQuery("select rd from RoomDescription rd " +
                "where rd.id = :id",RoomDescription.class)
                .setParameter("id",request.getId());
        List<RoomDescription> resultList = query.getResultList();
        return  resultList;
    }
}
