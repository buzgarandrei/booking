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
        roomDescription1.setDescription(entityManager.find(Description.class,13L));
        roomDescription1.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        entityManager.persist(roomDescription1);

        RoomDescription roomDescription2 = new RoomDescription();
        roomDescription2.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription2.setRoom(entityManager.find(Room.class,2L));
        roomDescription2.setDescription(entityManager.find(Description.class,14L));
        entityManager.persist(roomDescription2);

        RoomDescription roomDescriptionRoom3Romanian = new RoomDescription();
        roomDescriptionRoom3Romanian.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescriptionRoom3Romanian.setRoom(entityManager.find(Room.class,3L));
        roomDescriptionRoom3Romanian.setDescription(entityManager.find(Description.class,23L));
        entityManager.persist(roomDescriptionRoom3Romanian);

        RoomDescription roomDescription3 = new RoomDescription();
        roomDescription3.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription3.setRoom(entityManager.find(Room.class,3L));
        roomDescription3.setDescription(entityManager.find(Description.class,24L));
        entityManager.persist(roomDescription3);

        RoomDescription roomDescription4 = new RoomDescription();
        roomDescription4.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription4.setRoom(entityManager.find(Room.class,4L));
        roomDescription4.setDescription(entityManager.find(Description.class,25L));
        entityManager.persist(roomDescription4);

        RoomDescription roomDescription5 = new RoomDescription();
        roomDescription5.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription5.setRoom(entityManager.find(Room.class,4L));
        roomDescription5.setDescription(entityManager.find(Description.class,26L));
        entityManager.persist(roomDescription5);

        RoomDescription roomDescription6 = new RoomDescription();
        roomDescription6.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription6.setRoom(entityManager.find(Room.class,5L));
        roomDescription6.setDescription(entityManager.find(Description.class,27L));
        entityManager.persist(roomDescription6);

        RoomDescription roomDescription7 = new RoomDescription();
        roomDescription7.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription7.setRoom(entityManager.find(Room.class,5L));
        roomDescription7.setDescription(entityManager.find(Description.class,28L));
        entityManager.persist(roomDescription7);

        RoomDescription roomDescription8 = new RoomDescription();
        roomDescription8.setRoomDescriptionType(RoomDescriptionType.DESCRIPTION);
        roomDescription8.setRoom(entityManager.find(Room.class,1L));
        roomDescription8.setDescription(entityManager.find(Description.class,29L));
        entityManager.persist(roomDescription8);



    }

}
