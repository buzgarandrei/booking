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

        Description description14 = new Description();
        description14.setLanguage(Language.EN);
        description14.setText("Our parking lot has more then 200 places");
        entityManager.persist(description14);

        Description description15 = new Description();
        description15.setText("This is the description of the Phone facility");
        description15.setLanguage(Language.EN);
        entityManager.persist(description15);

        Description description16 = new Description();
        description16.setLanguage(Language.EN);
        description16.setText("This is the description of the Hotel Royal from Cluj-Napoca, a very important hotel from Gheorgheni neighbourhood");
        entityManager.persist(description16);

        Description description17 = new Description();
        description17.setLanguage(Language.EN);
        description17.setText("This is the description of the ALL - Inclusive facility");
        entityManager.persist(description17);

        Description description18 = new Description();
        description18.setLanguage(Language.EN);
        description18.setText("This is the description of the MiniBar facility");
        entityManager.persist(description18);

        Description description19 = new Description();
        description19.setLanguage(Language.EN);
        description19.setText("This is the description of the Restaurant facility");
        entityManager.persist(description19);

        Description description20 = new Description();
        description20.setLanguage(Language.EN);
        description20.setText("This is the description of the Smoking Friendley facility");
        entityManager.persist(description20);

        Description description21 = new Description();
        description21.setLanguage(Language.EN);
        description21.setText("This is the description of the Barbecue terrace amenaged place facility");
        entityManager.persist(description21);

        Description description22 = new Description();
        description22.setLanguage(Language.RO);
        description22.setText("Aceasta e descrierea camerei cu nr 3 din bd, apartine de Wonderland");
        entityManager.persist(description22);

        Description description23 = new Description();
        description23.setLanguage(Language.EN);
        description23.setText("This is the description of the Room 3 from db, a room of Wonderland");
        entityManager.persist(description23);

        Description description24 = new Description();
        description24.setLanguage(Language.RO);
        description24.setText("Aceasta e descrierea camerei cu nr 4 din bd, apartine de Continental");
        entityManager.persist(description24);

        Description description25 = new Description();
        description25.setLanguage(Language.EN);
        description25.setText("This is the description of the Room 4 from db, a room of Continental");
        entityManager.persist(description25);

        Description description26 = new Description();
        description26.setLanguage(Language.RO);
        description26.setText("Aceasta e descrierea camerei cu nr 5 din bd, apartine de Royal");
        entityManager.persist(description26);

        Description description27 = new Description();
        description27.setLanguage(Language.EN);
        description27.setText("This is the description of the Room 5 from db, a room of Royal");
        entityManager.persist(description27);

        Description description28 = new Description();
        description28.setLanguage(Language.RO);
        description28.setText("Aceasta e descrierea camerei cu nr 1 din bd, apartine de Wonderland");
        entityManager.persist(description28);


    }

}
