package com.example.booking.services;

import com.example.booking.requests.RoomBedListRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomBedListResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface RoomBedListService {
    List<RoomBedListResponse> getListOfAllBeds();

    StateResponse addBedToARoom(RoomBedListRequest request);

    StateResponse updateBedOfARoom(RoomBedListRequest request);

    void deleteBedOfARoom(RequestWithId request);

    List<RoomBedListResponse> getBedsOfARoom(RequestWithId request);
}
