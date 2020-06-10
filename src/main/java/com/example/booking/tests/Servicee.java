package com.example.booking.tests;

import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class Servicee {

    @Autowired
    DescriptionTest descriptionTest;

    @Autowired
    HotelDescriptionTest hotelDescriptionTest;

    @Autowired
    HotelTest hotelTest;

    @Autowired
    FacilityTest facilityTest;

    @Autowired
    RoomTest roomTest;

    @Autowired
    RoomDescriptionTest roomDescriptionTest;

    @Autowired
    PriceTest priceTest;

    @Autowired
    BedTypeTest bedTypeTest;

    @Autowired
    RoomBedListTest roomBedListTest;

    @Autowired
    QueryTester queryTester;

    @Autowired
    UserTest userTest;

    public void populate() throws Exception {

        userTest.populateUsers();
        descriptionTest.addDescription();
        facilityTest.addFacility();
        hotelTest.addHotel();
        hotelDescriptionTest.addHotelDescription();
        roomTest.addRoom();
        roomDescriptionTest.addRomDescription();
        priceTest.addPrice();
        priceTest.addPrice2();
        priceTest.addPrice3();
        priceTest.addPrice4();
        priceTest.addPrice5();
        bedTypeTest.addBedType();
        roomBedListTest.addBedsToList();

    }
    public List<SearchResponse> Run(SearchRequest request) throws Exception {

       /* queryTester.getHotelsWithRequestedFacility();
        queryTester.getRoomsBedList();*/
        return queryTester.getRoomsForGivenCriteria(request);
       /* queryTester.getPriceOffer();

        queryTester.getPriceOfRoomForGivenTimeFrame();*/
    }
    public AppointmentResponse makeAppointment(AppointmentRequest request) throws ParseException {

        return queryTester.makeAppointment(request);
    }

}
