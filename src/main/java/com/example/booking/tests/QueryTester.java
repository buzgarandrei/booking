package com.example.booking.tests;

import com.example.booking.entities.*;
import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.SearchResponse;
import com.example.booking.utils.FacilityNameEnum;
import com.example.booking.utils.Language;
import com.example.booking.utils.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public class QueryTester {

    @PersistenceContext
    EntityManager entityManager;


    @Transactional
    public void getHotelsWithRequestedFacility() {

        FacilityNameEnum facilityNameEnum = null;
        Query query = entityManager.createQuery(" select hotel from Hotel hotel join hotel.hotelFacilityList facility " +
                " where facility.facilityName = :param ", Hotel.class);
        query.setParameter("param", "POOL");

        List<Hotel> resultList = query.getResultList();

        for (Hotel elem : resultList) {

            System.out.println(elem.toString());

        }
    }

    @Transactional
    public void getRoomsBedList() {

        Query query = entityManager.createQuery(" select bedList from RoomBedList bedList " +
                "where bedList.room.id = :id", RoomBedList.class);
        query.setParameter("id", 1L);

        List<RoomBedList> roomBedLists = query.getResultList();

        for (RoomBedList elem : roomBedLists) {

            System.out.println(elem.toString());
        }
    }
@Transactional
    public String getDescriptionOfARoom(Long idRoom,Language language ) {

        Query query = entityManager.createQuery(" select descr.description.text from RoomDescription descr where descr.room.id = :id and descr.description.language = :language ", String.class);
        query.setParameter("language", language);
        query.setParameter("id", idRoom);

        return (String) query.getSingleResult();
    }

    @Transactional
    public List<FacilityResponse> getRoomFacilities(Long idRoom) {

        Query query = entityManager.createQuery("select room.facilityList from Room  room where room.id = :id ", Collection.class);
        query.setParameter("id", idRoom);
        List<Facility> resultList = query.getResultList();
        List<FacilityResponse> responseList = new ArrayList<>();
        for (Facility facility : resultList) {

            FacilityResponse response = new FacilityResponse();
            response.setId(facility.getId());
            response.setSVG(facility.getSVG());
            response.setFacilityName(facility.getFacilityName());
            response.setFacilityType(facility.getFacilityType());

            responseList.add(response);

        }
        return responseList;
    }

    @Transactional
    public List<FacilityResponse> getHotelFacilities(Long idRoom) {

        Query query = entityManager.createQuery(" select room.hotel.hotelFacilityList from Room  room where room.id = :id ", Collection.class);
        query.setParameter("id", idRoom);

        List<Facility> facilities = query.getResultList();
        List<FacilityResponse> responseList = new ArrayList<>();

        for( Facility facility : facilities) {
            FacilityResponse response = new FacilityResponse();
            response.setFacilityType(facility.getFacilityType());
            response.setFacilityName(facility.getFacilityName());
            response.setSVG(facility.getSVG());
            response.setId(facility.getId());

            responseList.add(response);
        }
        return responseList;
    }
    @Transactional
    public List<SearchResponse> getRoomsForGivenCriteria(SearchRequest request) throws ParseException {

        /*Query query = entityManager.createQuery(" select room from Room room " +
                " join room.hotel.hotelFacilityList hotelFacility join room.facilityList roomFacility " +
                " where room.available = true and room.nrOfAdults = :nrOfAdults and room.nrOfKids = :nrOfKids " +
                " and room.hotel.city = : city and hotelFacility.facilityNameEnum = :enum1 and roomFacility.facilityNameEnum = :enum2 ", Room.class);*/

        Query query = entityManager.createQuery(" select room from Room room " +
                " where room.available = true and room.nrOfAdults = :nrOfAdults and room.nrOfKids = :nrOfKids " +
                " and room.hotel.city = :city ", Room.class);
        query.setParameter("nrOfAdults", request.getNrOfAdults());
        query.setParameter("nrOfKids", request.getNrOfKids());
        query.setParameter("city", request.getCityName());
        /*query.setParameter("enum1", FacilityNameEnum.POOL);
        query.setParameter("enum2", FacilityNameEnum.WIFI);*/

        List<Room> rooms = query.getResultList();
        List<SearchResponse> responseList = new ArrayList<>();

        for (Room room : rooms) {

            SearchResponse response = new SearchResponse();

            response.setTotal(getPriceOfRoomForGivenTimeFrame(room.getId(),request.getDateStart(), request.getDateEnd()));
            response.setRoomDescription(getDescriptionOfARoom(room.getId(),request.getLanguage()));
            response.setStartDate(request.getDateStart());
            response.setEndDate(request.getDateEnd());
            response.setIdRoom(room.getId());
            response.setRoomFacilities(getRoomFacilities(room.getId()));
            response.setHotelFacilities(getHotelFacilities(room.getId()));

            responseList.add(response);
        }
        return responseList;
    }

    @Transactional
    public float getPriceOfRoomForGivenTimeFrame(Long id, String dateStart, String dateEnd) throws ParseException {

        //String dateStart = "2019-12-17";
        //String dateEnd = "2020-01-02";

        Date dateStartGiven = Utils.DATE_FORMAT.parse(dateStart);
        Date dateEndGiven = Utils.DATE_FORMAT.parse(dateEnd);

        System.out.println(Utils.DATE_FORMAT.format(dateStartGiven));
        System.out.println(Utils.DATE_FORMAT.format(dateEndGiven));

        System.out.println(Utils.getNoDays(dateStartGiven, dateEndGiven));


        Query queryPrice = entityManager.createQuery(" select prices from Price prices  " +
                " where (prices.startDate between :dateStart and :dateEnd or " +
                " prices.endDate between :dateStart and :dateEnd) and prices.room.id = :id", Price.class);

        queryPrice.setParameter("dateStart", dateStartGiven);
        queryPrice.setParameter("dateEnd", dateEndGiven);
        queryPrice.setParameter("id",id);

        List<Price> resultList = queryPrice.getResultList();

        float price = 0;

        switch (resultList.size()) {

            case 0:
                System.out.println("We couldn't get you a price for the given time interval");
                break;

            case 1:
                price = Utils.getNoDays(dateStartGiven,dateEndGiven)
                        * resultList.get(0).getAmount();
                System.out.println("The price for the given time interval is: " + price);
                break;

            case 2:
                price = (Utils.getNoDays(resultList.get(1).getStartDate(),dateEndGiven)
                        * resultList.get(1).getAmount()) +
                        (Utils.getNoDays(dateStartGiven, dateEndGiven)
                                * resultList.get(0).getAmount());
                System.out.println("The price for the given time interval is: " + price);
                break;

            default:
                price = (Utils.getNoDays(resultList.get(resultList.size() - 1).getStartDate(), dateEndGiven)
                        * resultList.get(resultList.size() - 1).getAmount()) +
                        (Utils.getNoDays(dateStartGiven, resultList.get(0).getEndDate())
                                * resultList.get(0).getAmount());

                for (int i = 1; i < resultList.size() - 1; i++) {
                            price = price + resultList.get(i).getAmount() * Utils.getNoDays(resultList.get(i).getStartDate(), resultList.get(i).getEndDate());

                }

                System.out.println("The price for the given time interval is :" + price);


        }
        return price;
    }

    @Transactional
    public AppointmentResponse makeAppointment(AppointmentRequest request) throws ParseException {

        AppointmentResponse response = new AppointmentResponse();
        Query appointmentQuery = entityManager.createQuery(" select app from Appointment app" +
                " where (app.startDate between :startDate and :endDate or " +
                " app.endDate between :startDate and :endDate) and app.room.id = :roomId ", Appointment.class)

                .setParameter("startDate", Utils.DATE_FORMAT.parse(request.getStartDate()))
                .setParameter("endDate", Utils.DATE_FORMAT.parse(request.getEndDate()))
                .setParameter("roomId", request.getRoomId());

        List<Appointment> resultList = appointmentQuery.getResultList();
        if(resultList.size() == 0) {
            Appointment app = new Appointment();
            app.setRoom(entityManager.find(Room.class,request.getRoomId()));
            app.setStartDate(Utils.DATE_FORMAT.parse(request.getStartDate()));
            app.setEndDate(Utils.DATE_FORMAT.parse(request.getEndDate()));
            app.setUser(entityManager.find(User.class,request.getUserId()));
            app.setAmmount(getPriceOfRoomForGivenTimeFrame(
                    app.getRoom().getId(), Utils.DATE_FORMAT.format(app.getStartDate()), Utils.DATE_FORMAT.format(app.getEndDate())));
            entityManager.persist(app);

            response.setStartDate(request.getStartDate());
            response.setEndDate(request.getEndDate());
            response.setRoomId(request.getRoomId());
            response.setUserId(request.getUserId());
            response.setAmmount(app.getAmmount());
        }
        return response;
    }

    /*@Transactional
    public void getPriceOffer() throws ParseException {

        String dateStart = "2019-12-17";
        String dateEnd = "2020-01-02";

        Date dateStartGiven = Utils.DATE_FORMAT.parse(dateStart);
        Date dateEndGiven = Utils.DATE_FORMAT.parse(dateEnd);

        System.out.println(Utils.DATE_FORMAT.format(dateStartGiven));
        System.out.println(Utils.DATE_FORMAT.format(dateEndGiven));

        System.out.println(Utils.getNoDays(dateStartGiven, dateEndGiven));

        String sql = " select r.id," +
                "       r.available," +
                "       h_description.text as hotel_description," +
                "       r.nr_of_adults," +
                "       r.nr_of_kids," +
                //"       r.id_room_description," +
                " " +
                "    p.amount," +
                "    p.start_date," +
                "    p.end_date," +
                " " +
                "    SUM(" +
                "        (" +
                "             SELECT" +
                "                 CASE" +
                "                     WHEN :dateStart >= p.start_date AND :dateEnd >= p.end_date THEN DATEDIFF(p.end_date, :dateStart) + 1" +
                "                     WHEN :dateStart <= p.start_date AND :dateEnd >= p.end_date THEN DATEDIFF(p.end_date, p.start_date) + 1" +
                "                     WHEN :dateStart <= p.start_date AND :dateEnd <= p.end_date THEN DATEDIFF(:dateEnd, p.start_date) + 1" +
                "                 END" +
                "             FROM price pp" +
                "             WHERE pp.id = p.id" +
                "        ) * p.amount" +
                "    ) as total" +
                " " +
                " from rooms r" +
                " inner join hotels h on r.id_hotel = h.id" +
                " left join hotel_description hd on h.id = hd.id_hotel" +
                //" left join description h_description on hd.id_description = h_description.id " +
                " inner join hotel_facilities hf on h.id = hf.id_hotel" +
                " inner join facility h_facility on hf.id_facility = h_facility.id" +
                " inner join room_facility rf on r.id = rf.id_room" +
                " inner join facility r_facility on rf.id_facility = r_facility.id" +
                " " +
                " inner join price p on r.id = p.id_room" +
                " " +
                " where r.available = 1" +
                "   and r.nr_of_adults = 2" +
                "   and r.nr_of_kids = 2" +
                "   and h.city = 'Cluj-Napoca'" +
                "   and h_facility.facility_name = :hotelFacility " +
                "   and r_facility.facility_name = :roomFacility " +
                "   and h_description.language = :language" +
                "   and (p.start_date between :dateStart and :dateEnd or p.end_date between :dateStart and :dateEnd)" +
                " " +
                " group by r.id" +
                " having (total > 10)" +
                " order by total";

        Query query = entityManager.createNativeQuery(sql, Tuple.class);

        query.setParameter("dateStart", dateStartGiven);
        query.setParameter("dateEnd", dateEndGiven);
        query.setParameter("hotelFacility", FacilityNameEnum.POOL.name());
        query.setParameter("roomFacility", FacilityNameEnum.WIFI.name());
        query.setParameter("language", Language.EN.name());
        List<Tuple> resultList = query.getResultList();

        for (Tuple tuple : resultList) {

            System.out.println(tuple.get("total"));
        }
    }*/
}
