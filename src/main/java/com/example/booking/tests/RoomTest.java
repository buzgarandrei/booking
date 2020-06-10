package com.example.booking.tests;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Hotel;
import com.example.booking.entities.Room;
import com.example.booking.entities.RoomDescription;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
class RoomTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addRoom() {

        Room room = new Room();
        room.setAvailable(true);

        room.setNrOfAdults(2);
        room.setNrOfKids(2);
        try {
            Facility facility = entityManager.find(Facility.class,1L);
            room.getFacilityList().add(facility);
        }
        catch (Exception e) {
            System.out.println("Problem appending facility");
            e.printStackTrace();
        }

        try {
            Hotel hotel = entityManager.find(Hotel.class,1L);
            room.setHotel(hotel);
        }
        catch (Exception e) {
            System.out.println("Problem appending hotel");
            e.printStackTrace();
        }


        entityManager.persist(room);

        Room room1 = new Room();
        room1.setNrOfKids(2);
        room1.setNrOfAdults(2);
        room1.setAvailable(true);
        room1.setHotel(entityManager.find(Hotel.class,2L));
        room1.getFacilityList().add(entityManager.find(Facility.class,1L));
        room1.getFacilityList().add(entityManager.find(Facility.class,3L));
        entityManager.persist(room1);

        Room room2 = new Room();
        room2.setNrOfKids(2);
        room2.setNrOfAdults(2);
        room2.setAvailable(true);
        room2.setHotel(entityManager.find(Hotel.class,2L));
        room2.getFacilityList().add(entityManager.find(Facility.class,1L));
        room2.getFacilityList().add(entityManager.find(Facility.class,3L));
        room2.getFacilityList().add(entityManager.find(Facility.class,5L));
        entityManager.persist(room2);

        Room room3 = new Room();
        room3.setNrOfKids(2);
        room3.setNrOfAdults(3);
        room3.setAvailable(true);
        room3.setHotel(entityManager.find(Hotel.class,1L));
        room3.getFacilityList().add(entityManager.find(Facility.class,3L));
        room3.getFacilityList().add(entityManager.find(Facility.class,7L));
        room3.getFacilityList().add(entityManager.find(Facility.class,9L));
        entityManager.persist(room3);

        Room room4 = new Room();
        room4.setNrOfKids(1);
        room4.setNrOfAdults(2);
        room4.setAvailable(true);
        room4.setHotel(entityManager.find(Hotel.class,3L));
        room4.getFacilityList().add(entityManager.find(Facility.class,1L));
        room4.getFacilityList().add(entityManager.find(Facility.class,3L));
        room4.getFacilityList().add(entityManager.find(Facility.class,5L));
        room4.getFacilityList().add(entityManager.find(Facility.class,7L));
        room4.getFacilityList().add(entityManager.find(Facility.class,9L));
        entityManager.persist(room4);




    }
}
