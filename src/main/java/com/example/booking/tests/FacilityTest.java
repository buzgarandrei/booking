package com.example.booking.tests;

import com.example.booking.entities.Description;
import com.example.booking.entities.Facility;
import com.example.booking.utils.FacilityNameEnum;
import com.example.booking.utils.FacilityType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
class FacilityTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addFacility() {

        Facility facility = new Facility();
        facility.setSVG("svg1");
        facility.setFacilityType(FacilityType.ROOM);
        facility.setFacilityName("WIFI");

        try {
            Description description = entityManager.find(Description.class,4L);
            List<Description> list = facility.getDescriptionList();
            list.add(description);
            facility.setDescriptionList(list);

        }
        catch (Exception e) {
            System.out.println("Problem with appending in description list");
            e.printStackTrace();
        }

        entityManager.persist(facility);


        Facility facility1 = new Facility();
        facility1.setSVG("svg2");
        facility1.setFacilityType(FacilityType.HOTEL);
        facility1.setFacilityName("POOL");

        try {
            Description description = entityManager.find(Description.class,3L);
            List<Description> list = facility1.getDescriptionList();
            list.add(description);
            facility1.setDescriptionList(list);
        }
        catch (Exception e) {
            System.out.println("Problem with appending in description list");
            e.printStackTrace();

        }

        entityManager.persist(facility1);

        Facility facility2 = new Facility();
        facility2.setFacilityName("TV");
        facility2.setSVG("svg3");
        facility2.setFacilityType(FacilityType.ROOM);
        facility2.getDescriptionList().add(entityManager.find(Description.class,10L));
        facility2.getDescriptionList().add(entityManager.find(Description.class,11L));
        entityManager.persist(facility2);
    }

}