package com.example.booking.tests;

import com.example.booking.entities.Price;
import com.example.booking.entities.Room;
import com.example.booking.utils.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.Date;

@Repository
class PriceTest {

    @PersistenceContext
    EntityManager entityManager;

    private Date parseStringToDate(String dateStr) throws Exception {

        Date date = Utils.DATE_FORMAT.parse(dateStr);
        return date;
    }

    @Transactional
    public void addPrice() throws Exception {

        Price price = new Price();
        price.setAmount((float) 10.50);
        Room room = entityManager.find(Room.class,1L);

        price.setRoom(room);

        String dateStart = "2019-12-16";
        price.setStartDate(parseStringToDate(dateStart));

        String dateEnd = "2019-12-22";
        price.setEndDate(parseStringToDate(dateEnd));

        entityManager.persist(price);


        Price price1 = new Price();
        price1.setAmount(11);

        price1.setRoom(room);

        String dateStart1 = "2019-12-23";
        price1.setStartDate(parseStringToDate(dateStart1));

        String endDate1 = "2019-12-29";
        price1.setEndDate(parseStringToDate(endDate1));

        entityManager.persist(price1);


        Price price2 = new Price();
        price2.setAmount((float) 11.50);

        price2.setRoom(room);

        String dateStart2 = "2019-12-30";
        price2.setStartDate(parseStringToDate(dateStart2));

        String dateEnd2 = "2020-01-05";
        price2.setEndDate(parseStringToDate(dateEnd2));

        entityManager.persist(price2);

        Price price3 = new Price();
        price3.setAmount((float) 11.50);

        price3.setRoom(room);

        String dateStart3 = "2020-01-06";
        price3.setStartDate(parseStringToDate(dateStart3));

        String dateEnd3 = "2020-01-12";
        price3.setEndDate(parseStringToDate(dateEnd3));

        entityManager.persist(price3);


    }
    @Transactional
    public void addPrice2() throws Exception{

        Price price = new Price();
        price.setAmount((float) 10.50);
        Room room = entityManager.find(Room.class,2L);

        price.setRoom(room);

        String dateStart = "2019-12-16";
        price.setStartDate(parseStringToDate(dateStart));

        String dateEnd = "2019-12-22";
        price.setEndDate(parseStringToDate(dateEnd));

        entityManager.persist(price);


        Price price1 = new Price();
        price1.setAmount(11);

        price1.setRoom(room);

        String dateStart1 = "2019-12-23";
        price1.setStartDate(parseStringToDate(dateStart1));

        String endDate1 = "2019-12-29";
        price1.setEndDate(parseStringToDate(endDate1));

        entityManager.persist(price1);


        Price price2 = new Price();
        price2.setAmount((float) 11.50);

        price2.setRoom(room);

        String dateStart2 = "2019-12-30";
        price2.setStartDate(parseStringToDate(dateStart2));

        String dateEnd2 = "2020-01-05";
        price2.setEndDate(parseStringToDate(dateEnd2));

        entityManager.persist(price2);

        Price price3 = new Price();
        price3.setAmount((float) 11.50);

        price3.setRoom(room);

        String dateStart3 = "2020-01-06";
        price3.setStartDate(parseStringToDate(dateStart3));

        String dateEnd3 = "2020-01-12";
        price3.setEndDate(parseStringToDate(dateEnd3));

        entityManager.persist(price3);

    }

}