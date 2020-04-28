package com.example.booking.tests;

import com.example.booking.entities.Description;
import com.example.booking.entities.Room;
import com.example.booking.entities.RoomDescription;
import com.example.booking.utils.RoomDescriptionType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
class RoomDescriptionTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addRomDescription() {

        RoomDescription roomDescription = new RoomDescription();
        roomDescription.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);

        Description description = entityManager.find(Description.class,4L);
        roomDescription.setDescription(description);

        Room room = entityManager.find(Room.class,1L);
        roomDescription.setRoom(room);

        entityManager.persist(roomDescription);

        RoomDescription roomDescription1 = new RoomDescription();
        roomDescription1.setRoom(entityManager.find(Room.class,2L));
        roomDescription1.setDescription(entityManager.find(Description.class,12L));
        roomDescription1.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        entityManager.persist(roomDescription1);

        RoomDescription roomDescription2 = new RoomDescription();
        roomDescription2.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription2.setRoom(entityManager.find(Room.class,2L));
        roomDescription2.setDescription(entityManager.find(Description.class,13L));
        entityManager.persist(roomDescription2);


    }

}