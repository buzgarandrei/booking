package com.example.booking.repositories;

import com.example.booking.entities.*;
import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.requests.UserRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.SearchResponse;
import com.example.booking.responses.UserResponse;
import com.example.booking.utils.Language;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import com.example.booking.utils.Utils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.Tuple;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<UserResponse> getUsers() {

        Query query = entityManager.createQuery(" select user from User user ", User.class);

        List<User> resultList = query.getResultList();
        List<UserResponse> responseList = new ArrayList<>();

        for (User user : resultList) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setName(user.getName());
            response.setEmail(user.getEmail());
            response.setRoleEnum(user.getRoleEnum());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    @Transactional
    public StateResponse addUser(UserRequest request) {

        StateResponse stateResponse = new StateResponse();
        if (request.getName() == null || request.getPassword() == null | request.getEmail() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRoleEnum(RoleEnum.BASIC_USER);
        user.setPassword(request.getPassword());

        entityManager.persist(user);
        stateResponse.setSuccess(true);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateUser(UserRequest request) {

        StateResponse stateResponse = new StateResponse();
        User user = entityManager.find(User.class, request.getId());
        if (user == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        if (request.getEmail() != null) user.setEmail(request.getEmail());
        if (request.getName() != null) user.setName(request.getName());
        if (request.getPassword() != null) user.setPassword(request.getPassword());

        entityManager.merge(user);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteUser(RequestWithId request) {

        User user = entityManager.find(User.class, request.getId());
        entityManager.remove(user);
    }

    @Override
    @Transactional
    public void makeAdmin(RequestWithId request) {

        User user = entityManager.find(User.class, request.getId());
        user.setRoleEnum(RoleEnum.ADMIN);

        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void makeOwner(RequestWithId request) {

        User user = entityManager.find(User.class, request.getId());
        user.setRoleEnum(RoleEnum.OWNER);

        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void makePremiumUser(RequestWithId request) {

        User user = entityManager.find(User.class, request.getId());
        user.setRoleEnum(RoleEnum.PREMIUM_USER);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse login(UserRequest userRequest) {

        Query query = entityManager.createQuery("select user.id, user.name from User user" +
                " where user.email = :email and user.password = :pass", Tuple.class);
        query.setParameter("email", userRequest.getEmail());
        query.setParameter("pass", userRequest.getPassword());

        UserResponse response = new UserResponse();
        Tuple tuple = (Tuple) query.getResultList().stream().findFirst().orElse(null);
        if(tuple != null) {
            response.setId((Long) tuple.get(0));
            response.setName(tuple.get(1).toString());
        }
        return response;

    }

    @Override
    @Transactional(readOnly = true)
    public RoleEnum getUserRole(Long id) {

        Query query = entityManager.createQuery(" select user.roleEnum from User user where user.id = :id ", RoleEnum.class);
        query.setParameter("id", id);

        return (RoleEnum) query.getSingleResult();
    }

    @Transactional
    public String getDescriptionOfARoom(Long idRoom, Language language ) {

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
    @Override
    public List<SearchResponse> search(SearchRequest request) throws ParseException {

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

}

