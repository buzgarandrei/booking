package com.example.booking.services;


import com.example.booking.entities.RoomBedList;
import com.example.booking.repositories.RoomBedListRepository;
import com.example.booking.requests.RoomBedListRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomBedListResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomBedListServiceImpl implements RoomBedListService {

    @Autowired
    RoomBedListRepository roomBedListRepository;

    @Override
    public List<RoomBedListResponse> getListOfAllBeds() {
        List<RoomBedList> entities = roomBedListRepository.getListOfAllBeds();
        List<RoomBedListResponse> responseList = new ArrayList<>();
        for (RoomBedList entity : entities) {
            RoomBedListResponse response = new RoomBedListResponse();
            response.setBedTypeId((long) entity.getBedType().getId());
            response.setNoOfBeds(entity.getNoOfBeds());
            response.setRoomId(entity.getRoom().getId());
            response.setId(entity.getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public StateResponse addBedToARoom(RoomBedListRequest request) {
        return roomBedListRepository.addBedToARoom(request);
    }

    @Override
    public StateResponse updateBedOfARoom(RoomBedListRequest request) {
        return roomBedListRepository.updateBedOfARoom(request);
    }

    @Override
    public void deleteBedOfARoom(RequestWithId request) {
        roomBedListRepository.deleteBedOfARoom(request);
    }

    @Override
    public List<RoomBedListResponse> getBedsOfARoom(RequestWithId request) {
        List<RoomBedList> listOfBeds = roomBedListRepository.getBedsOfARoom(request);
        List<RoomBedListResponse> responseList = new ArrayList<>();
        for (RoomBedList listOfBed : listOfBeds) {
            RoomBedListResponse response = new RoomBedListResponse();
            response.setId(listOfBed.getId());
            response.setRoomId(listOfBed.getRoom().getId());
            response.setNoOfBeds(listOfBed.getNoOfBeds());
            response.setBedTypeId((long) listOfBed.getBedType().getId());

            responseList.add(response);
        }
        return responseList;
    }
}
