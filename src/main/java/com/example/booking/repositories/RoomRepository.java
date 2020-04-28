package com.example.booking.repositories;

import com.example.booking.entities.Facility;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.RoomRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface RoomRepository {
    List<RoomResponse> getRooms();

    StateResponse addRoom(RoomRequest roomRequest);

    StateResponse updateRoom(RoomRequest roomRequest);

    void deleteRoom(RequestWithId request);

    StateResponse addRoomFacility(RequestWith2Ids request);

    StateResponse deleteRoomFacility(RequestWith2Ids request);

    List<Facility> getRoomFacilities(RequestWithId request);
}
