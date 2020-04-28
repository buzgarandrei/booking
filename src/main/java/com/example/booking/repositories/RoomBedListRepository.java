package com.example.booking.repositories;

import com.example.booking.entities.RoomBedList;
import com.example.booking.requests.RoomBedListRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface RoomBedListRepository {
    List<RoomBedList> getListOfAllBeds();

    StateResponse addBedToARoom(RoomBedListRequest request);

    StateResponse updateBedOfARoom(RoomBedListRequest request);
    void deleteBedOfARoom(RequestWithId request);

    List<RoomBedList> getBedsOfARoom(RequestWithId request);
}
