package com.example.booking.repositories;

import com.example.booking.entities.RoomDescription;
import com.example.booking.requests.RoomDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


public interface RoomDescriptionRepository {

    List<RoomDescription> getRoomDescriptions();

    StateResponse addRoomDescription(RoomDescriptionRequest request);

    StateResponse updateRoomDescription(RoomDescriptionRequest request);

    void deleteRoomDescription(RequestWithId request);

    List<RoomDescription> getDescriptionsOfARoom(RequestWithId request);
}
