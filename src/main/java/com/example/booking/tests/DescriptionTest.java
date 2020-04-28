package com.example.booking.tests;


import com.example.booking.entities.Description;
import com.example.booking.utils.Language;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class DescriptionTest {

    @PersistenceContext
    public EntityManager entityManager;

    @Transactional
    public void addDescription() {

        Description description = new Description();
        description.setLanguage(Language.EN);
        description.setText("Here we have the description for the Continental hotel of Cluj-Napoca");
        entityManager.persist(description);

        Description description1 = new Description();
        description1.setLanguage(Language.FR);
        description1.setText("C'est le description du Hotel Continental dans Cluj-Napoca");
        entityManager.persist(description1);

        Description description2 = new Description();
        description2.setLanguage(Language.EN);
        description2.setText("This is the description of the facilities of the hotel Continental of Cluj-Napoca");
        entityManager.persist(description2);

        Description description3 =  new Description();
        description3.setLanguage(Language.EN);
        description3.setText("This is the description of the  facilities of the room 1 of Continental Hotel from Cluj-Napoca");
        entityManager.persist(description3);

        Description description4 = new Description();
        description4.setLanguage(Language.EN);
        description4.setText("This is the description of the room 2 of the Continental Hotel from Cluj-Napoca");
        entityManager.persist(description4);

        Description description5 = new Description();
        description5.setLanguage(Language.EN);
        description5.setText("This is the description of the Wonderland Hotel, nearby Cluj-Napoca");
        entityManager.persist(description5);

        Description description6 = new Description();
        description6.setLanguage(Language.EN);
        description6.setText("This is the description of the facilities of the Hotel Wonderland from nearby Cluj-Napoca");
        entityManager.persist(description6);

        Description description7 = new Description();
        description7.setLanguage(Language.EN);
        description7.setText("This is the description of the room number 204 of the Wonderland Hotel, from nearby Cluj-Napoca");
        entityManager.persist(description7);

        Description description8 = new Description();
        description8.setLanguage(Language.EN);
        description8.setText("This is the description of the region of Cluj");
        entityManager.persist(description8);

        Description description9 = new Description();
        description9.setLanguage(Language.EN);
        description9.setText("This is the description of the region of Alba");
        entityManager.persist(description9);

        Description description10 = new Description();
        description10.setText("This is the description of the TV room Facility");
        description10.setLanguage(Language.EN);
        entityManager.persist(description10);

        Description description11 = new Description();
        description11.setLanguage(Language.RO);
        description11.setText("Aceasta e descrierea facilitatii de camera TV in romana");
        entityManager.persist(description11);

        Description description12 = new Description();
        description12.setText("This is the description of the room number 12 from Wonderland Hotel, Cluj-Napoca, Romania");
        description12.setLanguage(Language.EN);
        entityManager.persist(description12);

        Description description13 = new Description();
        description13.setText("Aceasta e descrierea in romana a camerei cu numarul 12 din cadrul Hotelului Wonderland, Cluj-Napoca, Romania");
        description13.setLanguage(Language.RO);
        entityManager.persist(description13);


    }

}