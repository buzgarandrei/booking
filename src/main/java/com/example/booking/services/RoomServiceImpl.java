package com.example.booking.services;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Price;
import com.example.booking.repositories.RoomRepository;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.RoomRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.PriceResponse;
import com.example.booking.responses.RoomResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;


    @Override
    public List<RoomResponse> getRooms() {

       return roomRepository.getRooms();
    }

    @Override
    @Transactional
    public StateResponse addRoom(RoomRequest roomRequest) {

        return roomRepository.addRoom(roomRequest);
    }

    @Override
    @Transactional
    public StateResponse updateRoom(RoomRequest roomRequest) {

        return roomRepository.updateRoom(roomRequest);
    }

    @Override
    public void deleteRoom(RequestWithId request) {

        roomRepository.deleteRoom(request);
    }

    @Override
    public StateResponse addRoomFacility(RequestWith2Ids request) {
        return roomRepository.addRoomFacility(request);
    }

    @Override
    public StateResponse deleteRoomFacility(RequestWith2Ids request) {
        return roomRepository.deleteRoomFacility(request);
    }

    @Override
    public List<FacilityResponse> getRoomFacilities(RequestWithId request) {

        List<Facility> entities = roomRepository.getRoomFacilities(request);
        List<FacilityResponse> responseList = new ArrayList<>();
        for (Facility entity : entities) {
            FacilityResponse response = new FacilityResponse();
            response.setId(entity.getId());
            response.setFacilityName(entity.getFacilityName());
            response.setSVG(entity.getSVG());
            response.setFacilityType(entity.getFacilityType());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<PriceResponse> getPricesOfRoom(RequestWithId request) {
        List<Price> priceList = roomRepository.getPricesOfRoom(request);
        List<PriceResponse> responseList = new ArrayList<>();
        for (Price price : priceList) {
            PriceResponse response = new PriceResponse();
            response.setId(price.getId());
            response.setAmount(price.getAmount());
            response.setEndDate(String.valueOf(price.getEndDate()));
            response.setStartDate(String.valueOf(price.getStartDate()));
            response.setIdRoom(price.getRoom().getId());
            responseList.add(response);
        }
        return responseList;
    }
}
