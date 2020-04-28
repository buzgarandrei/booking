package com.example.booking.tests;

import com.example.booking.entities.BedType;
import com.example.booking.entities.Room;
import com.example.booking.entities.RoomBedList;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoomBedListTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addBedsToList() {

        RoomBedList roomBedList = new RoomBedList();

        try {
            Room room = entityManager.find(Room.class,1L);
            roomBedList.setRoom(room);
        }
        catch (Exception e) {
            System.out.println("Problem finding the room for making a list of its beds");
        }

        try {
            BedType bedType = entityManager.find(BedType.class,2);
            roomBedList.setBedType(bedType);
        }
        catch (Exception e) {
            System.out.println("Bad type of bed for adding to a list of beds");
        }

        roomBedList.setNoOfBeds(2);

        entityManager.persist(roomBedList);


    }
}
