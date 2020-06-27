package com.example.booking.services;

import com.example.booking.requests.HotelRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.HotelResponse;
import com.example.booking.responses.RoomResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface HotelService {
    List<HotelResponse> getHotels();

    StateResponse addHotel(HotelRequest request);

    StateResponse updateHotel(HotelRequest request);

    void deleteHotel(RequestWithId request);

    StateResponse addHotelFacility(RequestWith2Ids request);

    StateResponse deleteHotelFacility(RequestWith2Ids request);

    List<FacilityResponse> getHotelFacilities(RequestWithId request);

    List<RoomResponse> getRoomsOfAHotel(RequestWithId request);

    List<HotelResponse> getHotelsOfOwner(RequestWithId requestWithId);

    List<AppointmentResponse> getAppointmentsAtAHotel(Long idUser);
}
