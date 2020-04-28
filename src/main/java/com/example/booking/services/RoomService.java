package com.example.booking.services;

import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.RoomRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.RoomResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface RoomService {
    List<RoomResponse> getRooms();

    StateResponse addRoom(RoomRequest roomRequest);

    StateResponse updateRoom(RoomRequest roomRequest);

    void deleteRoom(RequestWithId request);

    StateResponse addRoomFacility(RequestWith2Ids request);

    StateResponse deleteRoomFacility(RequestWith2Ids request);

    List<FacilityResponse> getRoomFacilities(RequestWithId request);
}
