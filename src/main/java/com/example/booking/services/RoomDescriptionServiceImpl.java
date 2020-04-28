package com.example.booking.services;

import com.example.booking.entities.RoomDescription;
import com.example.booking.repositories.RoomDescriptionRepository;
import com.example.booking.requests.RoomDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomDescriptionResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomDescriptionServiceImpl implements RoomDescriptionService {

    @Autowired
    RoomDescriptionRepository roomDescriptionRepository;

    @Override
    public List<RoomDescriptionResponse> getRoomDescriptions() {
        List<RoomDescription> entities = roomDescriptionRepository.getRoomDescriptions();
        List<RoomDescriptionResponse> responseList = new ArrayList<>();
        for (RoomDescription entity : entities) {
            RoomDescriptionResponse response = new RoomDescriptionResponse();
            response.setDescriptionId(entity.getDescription().getId());
            response.setRoomDescriptionType(entity.getRoomDescriptionType().toString());
            response.setRoomId(entity.getRoom().getId());
            response.setId(entity.getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public StateResponse addRoomDescription(RoomDescriptionRequest request) {
        return roomDescriptionRepository.addRoomDescription(request);
    }

    @Override
    public StateResponse updateRoomDescription(RoomDescriptionRequest request) {
        return roomDescriptionRepository.updateRoomDescription(request);
    }

    @Override
    public void deleteRoomDescription(RequestWithId request) {
        roomDescriptionRepository.deleteRoomDescription(request);
    }

    @Override
    public List<RoomDescriptionResponse> getDescriptionsOfARoom(RequestWithId request) {
        List<RoomDescription> entities = roomDescriptionRepository.getDescriptionsOfARoom(request);
        List<RoomDescriptionResponse> responseList = new ArrayList<>();
        for (RoomDescription entity : entities) {
            RoomDescriptionResponse response = new RoomDescriptionResponse();
            response.setDescriptionId(entity.getDescription().getId());
            response.setRoomDescriptionType(entity.getRoomDescriptionType().toString());
            response.setRoomId(entity.getRoom().getId());
            response.setId(entity.getId());

            responseList.add(response);
        }
        return responseList;

    }
}
