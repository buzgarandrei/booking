package com.example.booking.tests;

import com.example.booking.entities.Description;
import com.example.booking.entities.Hotel;
import com.example.booking.entities.HotelDescription;
import com.example.booking.utils.HotelDescriptionType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class HotelDescriptionTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addHotelDescription() {

        HotelDescription hotelDescription = new HotelDescription();
        hotelDescription.setHotelDescriptionType(HotelDescriptionType.DESCRIPTION);

        Description description = entityManager.find(Description.class,1L);
        hotelDescription.setDescription(description);

        //HotelDescription hotelDescription = entityManager.find(HotelDescription.class,1L);
        //hotel.setHotelDescription(hotelDescription);
        Hotel hotel = entityManager.find(Hotel.class,1L);
        hotelDescription.setHotel(hotel);

        entityManager.persist(hotelDescription);


        HotelDescription hotelDescription1 = new HotelDescription();
        hotelDescription1.setHotelDescriptionType(HotelDescriptionType.DESCRIPTION);

        Description description1 = entityManager.find(Description.class,6L);
        hotelDescription1.setDescription(description1);

        Hotel hotel1 = entityManager.find(Hotel.class,2L);
        hotelDescription1.setHotel(hotel1);

        entityManager.persist(hotelDescription1);
    }

}