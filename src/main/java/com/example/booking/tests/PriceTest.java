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

        Room room = entityManager.find(Room.class,1L);

        Price price3 = new Price();
        price3.setAmount((float) 11.50);

        price3.setRoom(room);

        String dateStart3 = "2020-06-22";
        price3.setStartDate(parseStringToDate(dateStart3));

        String dateEnd3 = "2020-06-28";
        price3.setEndDate(parseStringToDate(dateEnd3));

        entityManager.persist(price3);

        Price price = new Price();
        price.setAmount((float) 10.50);

        price.setRoom(room);

        String dateStart = "2020-06-29";
        price.setStartDate(parseStringToDate(dateStart));

        String dateEnd = "2020-07-05";
        price.setEndDate(parseStringToDate(dateEnd));

        entityManager.persist(price);


        Price price1 = new Price();
        price1.setAmount(11);

        price1.setRoom(room);

        String dateStart1 = "2020-07-06";
        price1.setStartDate(parseStringToDate(dateStart1));

        String endDate1 = "2020-07-12";
        price1.setEndDate(parseStringToDate(endDate1));

        entityManager.persist(price1);


        Price price2 = new Price();
        price2.setAmount((float) 11.50);

        price2.setRoom(room);

        String dateStart2 = "2020-07-13";
        price2.setStartDate(parseStringToDate(dateStart2));

        String dateEnd2 = "2020-07-19";
        price2.setEndDate(parseStringToDate(dateEnd2));

        entityManager.persist(price2);



    }
    @Transactional
    public void addPrice2() throws Exception{

        Room room = entityManager.find(Room.class,2L);

        Price price3 = new Price();
        price3.setAmount((float) 9.50);

        price3.setRoom(room);

        String dateStart3 = "2020-06-22";
        price3.setStartDate(parseStringToDate(dateStart3));

        String dateEnd3 = "2020-06-28";
        price3.setEndDate(parseStringToDate(dateEnd3));

        entityManager.persist(price3);

        Price price = new Price();
        price.setAmount((float) 8.50);

        price.setRoom(room);

        String dateStart = "2020-06-29";
        price.setStartDate(parseStringToDate(dateStart));

        String dateEnd = "2020-07-05";
        price.setEndDate(parseStringToDate(dateEnd));

        entityManager.persist(price);


        Price price1 = new Price();
        price1.setAmount(11);

        price1.setRoom(room);

        String dateStart1 = "2020-07-06";
        price1.setStartDate(parseStringToDate(dateStart1));

        String endDate1 = "2020-07-12";
        price1.setEndDate(parseStringToDate(endDate1));

        entityManager.persist(price1);


        Price price2 = new Price();
        price2.setAmount((float) 10.50);

        price2.setRoom(room);

        String dateStart2 = "2020-07-13";
        price2.setStartDate(parseStringToDate(dateStart2));

        String dateEnd2 = "2020-07-19";
        price2.setEndDate(parseStringToDate(dateEnd2));

        entityManager.persist(price2);

    }

    @Transactional
    public void addPrice3() throws Exception {
        Price price = new Price();
        price.setAmount(9);
        String dateStart = "2020-06-15";
        price.setStartDate(parseStringToDate(dateStart));
        String dateEnd = "2020-06-30";
        price.setEndDate(parseStringToDate(dateEnd));
        price.setRoom(entityManager.find(Room.class, 3L));
        entityManager.persist(price);

        Price price1 = new Price();
        String dateStart1 = "2020-07-01";
        price1.setStartDate(parseStringToDate(dateStart1));
        String dateEnd1 = "2020-07-12";
        price1.setEndDate(parseStringToDate(dateEnd1));
        price1.setRoom(entityManager.find(Room.class,3L));
        price1.setAmount((float) 10.5);
        entityManager.persist(price1);

        Price price2 = new Price();
        String dateStart2 = "2020-07-13";
        String endDate2 = "2020-07-26";
        price2.setAmount(11);
        price2.setRoom(entityManager.find(Room.class,3L));
        price2.setStartDate(parseStringToDate(dateStart2));
        price2.setEndDate(parseStringToDate(endDate2));
        entityManager.persist(price2);
    }

    @Transactional
    public void addPrice4() throws Exception {
        Price price = new Price();
        price.setAmount((float) 9.5);
        String dateStart = "2020-06-15";
        price.setStartDate(parseStringToDate(dateStart));
        String dateEnd = "2020-06-30";
        price.setEndDate(parseStringToDate(dateEnd));
        price.setRoom(entityManager.find(Room.class, 4L));
        entityManager.persist(price);

        Price price1 = new Price();
        String dateStart1 = "2020-07-01";
        price1.setStartDate(parseStringToDate(dateStart1));
        String dateEnd1 = "2020-07-12";
        price1.setEndDate(parseStringToDate(dateEnd1));
        price1.setRoom(entityManager.find(Room.class,4L));
        price1.setAmount((float) 11.5);
        entityManager.persist(price1);

        Price price2 = new Price();
        String dateStart2 = "2020-07-13";
        String endDate2 = "2020-07-26";
        price2.setAmount(12);
        price2.setRoom(entityManager.find(Room.class,4L));
        price2.setStartDate(parseStringToDate(dateStart2));
        price2.setEndDate(parseStringToDate(endDate2));
        entityManager.persist(price2);
    }

    @Transactional
    public void addPrice5() throws Exception {
        Price price = new Price();
        price.setAmount((float) 11.5);
        String dateStart = "2020-06-15";
        price.setStartDate(parseStringToDate(dateStart));
        String dateEnd = "2020-06-30";
        price.setEndDate(parseStringToDate(dateEnd));
        price.setRoom(entityManager.find(Room.class, 5L));
        entityManager.persist(price);

        Price price1 = new Price();
        String dateStart1 = "2020-07-01";
        price1.setStartDate(parseStringToDate(dateStart1));
        String dateEnd1 = "2020-07-12";
        price1.setEndDate(parseStringToDate(dateEnd1));
        price1.setRoom(entityManager.find(Room.class,5L));
        price1.setAmount((float) 12.5);
        entityManager.persist(price1);

        Price price2 = new Price();
        String dateStart2 = "2020-07-13";
        String endDate2 = "2020-07-26";
        price2.setAmount(15);
        price2.setRoom(entityManager.find(Room.class,5L));
        price2.setStartDate(parseStringToDate(dateStart2));
        price2.setEndDate(parseStringToDate(endDate2));
        entityManager.persist(price2);
    }



}
