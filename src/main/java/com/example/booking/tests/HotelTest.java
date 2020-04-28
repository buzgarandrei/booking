package com.example.booking.tests;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Hotel;
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

        try {
            Facility facility = entityManager.find(Facility.class,2L);
            hotel.getHotelFacilityList().add(facility);
        }
        catch (Exception e) {
            System.out.println("Problem appending");
        }



        entityManager.persist(hotel);



        Hotel hotel1 = new Hotel();
        hotel1.setName("Hotel Wonderland");
        hotel1.setCity("Cluj-Napoca");

        //HotelDescription hotelDescription1 = entityManager.find(HotelDescription.class,2L);
        //hotel1.setHotelDescription(hotelDescription1);

        entityManager.persist(hotel1);


    }




}