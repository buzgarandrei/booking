package com.example.booking.tests;

import com.example.booking.entities.Description;
import com.example.booking.entities.Facility;
import com.example.booking.entities.Hotel;
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
        facility.setSVG("https://www.svgrepo.com/show/75865/wifi.svg");
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
        facility1.setSVG("https://www.svgrepo.com/show/194834/swimming-pool.svg");
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
        facility2.setSVG("https://www.svgrepo.com/show/3693/television.svg");
        facility2.setFacilityType(FacilityType.ROOM);
        facility2.getDescriptionList().add(entityManager.find(Description.class,11L));
        facility2.getDescriptionList().add(entityManager.find(Description.class,12L));
        entityManager.persist(facility2);

        Facility facility3 = new Facility();
        facility3.setFacilityName("PARKING LOT");
        facility3.setFacilityType(FacilityType.HOTEL);
        facility3.setSVG("https://image.flaticon.com/icons/svg/75/75099.svg");
        facility3.getDescriptionList().add(entityManager.find(Description.class,15L));
        entityManager.persist(facility3);

        Facility facility4 = new Facility();
        facility4.setFacilityType(FacilityType.ROOM);
        facility4.setSVG("https://www.svgrepo.com/show/10677/telephone.svg");
        facility4.setFacilityName("PHONE");
        facility4.getDescriptionList().add(entityManager.find(Description.class,16L));
        entityManager.persist(facility4);

        Facility facility5 = new Facility();
        facility5.setFacilityType(FacilityType.HOTEL);
        facility5.setSVG("https://www.svgrepo.com/show/10677/telephone.svg");
        facility5.setFacilityName("ALL-INCLUSIVE");
        facility5.getDescriptionList().add(entityManager.find(Description.class,18L));
        entityManager.persist(facility5);

        Facility facility6 = new Facility();
        facility6.setFacilityType(FacilityType.ROOM);
        facility6.setSVG("https://www.svgrepo.com/show/10677/telephone.svg");
        facility6.setFacilityName("MINI-BAR");
        facility6.getDescriptionList().add(entityManager.find(Description.class,19L));
        entityManager.persist(facility6);

        Facility facility7 = new Facility();
        facility7.setFacilityType(FacilityType.HOTEL);
        facility7.setSVG("https://www.svgrepo.com/show/10677/telephone.svg");
        facility7.setFacilityName("RESTAURANT");
        facility7.getDescriptionList().add(entityManager.find(Description.class,20L));
        entityManager.persist(facility7);

        Facility facility8 = new Facility();
        facility8.setFacilityType(FacilityType.ROOM);
        facility8.setSVG("https://www.svgrepo.com/show/10677/telephone.svg");
        facility8.setFacilityName("SMOKING-FRIENDLY");
        facility8.getDescriptionList().add(entityManager.find(Description.class,21L));
        entityManager.persist(facility8);

        Facility facility9 = new Facility();
        facility9.setFacilityType(FacilityType.HOTEL);
        facility9.setSVG("https://www.svgrepo.com/show/10677/telephone.svg");
        facility9.setFacilityName("Barbecue-Teracce");
        facility9.getDescriptionList().add(entityManager.find(Description.class,22L));
        entityManager.persist(facility9);

    }

}
