package com.example.booking.repositories;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Room;
import com.example.booking.requests.HotelRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.HotelResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;


public interface HotelRepository {
    List<HotelResponse> getHotels();

    StateResponse addHotel(HotelRequest request);

    StateResponse updateHotel(HotelRequest request);

    void deleteHotel(RequestWithId request);

    StateResponse addHotelFacility(RequestWith2Ids request);

    StateResponse deleteHotelFacility(RequestWith2Ids request);

    List<Facility> getHotelFacilities(RequestWithId request);

    List<Room> getRoomsOfAHotel(RequestWithId request);

    List<HotelResponse> getHotelsOfOwner(RequestWithId requestWithId);
}
