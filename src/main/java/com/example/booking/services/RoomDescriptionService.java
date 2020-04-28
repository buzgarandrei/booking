package com.example.booking.services;

import com.example.booking.requests.RoomDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomDescriptionResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface RoomDescriptionService {
    List<RoomDescriptionResponse> getRoomDescriptions();

    StateResponse addRoomDescription(RoomDescriptionRequest request);

    StateResponse updateRoomDescription(RoomDescriptionRequest request);

     void deleteRoomDescription(RequestWithId request);

    List<RoomDescriptionResponse> getDescriptionsOfARoom(RequestWithId request);
}
