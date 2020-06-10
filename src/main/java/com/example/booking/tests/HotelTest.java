package com.example.booking.tests;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Hotel;
import com.example.booking.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HotelTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addHotel() {

        Hotel hotel = new Hotel();
        hotel.setName("Hotel Continental");
        hotel.setCity("Cluj-Napoca");
        hotel.setUser(entityManager.find(User.class,3L));

        hotel.getHotelFacilityList().add(entityManager.find(Facility.class,2L));
        hotel.getHotelFacilityList().add(entityManager.find(Facility.class,4L));
        hotel.getHotelFacilityList().add(entityManager.find(Facility.class,6L));
        hotel.getHotelFacilityList().add(entityManager.find(Facility.class,10L));

        entityManager.persist(hotel);



        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel Wonderland");
        hotel1.setCity("Cluj-Napoca");
        hotel1.setUser(entityManager.find(User.class,5L));
        hotel1.getHotelFacilityList().add(entityManager.find(Facility.class,2L));
        hotel1.getHotelFacilityList().add(entityManager.find(Facility.class,6L));
        hotel1.getHotelFacilityList().add(entityManager.find(Facility.class,10L));

        entityManager.persist(hotel1);


        Hotel hotel2 = new Hotel();
        hotel2.setUser(entityManager.find(User.class,5L));
        hotel2.setCity("Cluj-Napoca");
        hotel2.setName("Hotel Royal");
        hotel2.getHotelFacilityList().add(entityManager.find(Facility.class,2L));
        hotel2.getHotelFacilityList().add(entityManager.find(Facility.class,4L));
        hotel2.getHotelFacilityList().add(entityManager.find(Facility.class,6L));
        hotel2.getHotelFacilityList().add(entityManager.find(Facility.class,8L));
        hotel2.getHotelFacilityList().add(entityManager.find(Facility.class,10L));
        entityManager.persist(hotel2);

    }




}
