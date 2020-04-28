package com.example.booking.controllers;

import com.example.booking.requests.RoomDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomDescriptionResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.RoomDescriptionService;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomDescriptionController {

    @Autowired
    RoomDescriptionService roomDescriptionService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getRoomDescriptions")
    public List<RoomDescriptionResponse> getRoomDescriptions() {
        return roomDescriptionService.getRoomDescriptions();
    }

    @RequestMapping(value = "/getDescriptionsOfARoom")
    public List<RoomDescriptionResponse> getDescriptionsOfARoom(@RequestBody RequestWithId request) {
        return roomDescriptionService.getDescriptionsOfARoom(request);
    }

    @RequestMapping(value = "/addRoomDescription", method = RequestMethod.POST)
    public StateResponse addRoomDescription(@RequestBody RoomDescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(roomDescriptionService.addRoomDescription(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }

        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateRoomDescription", method = RequestMethod.POST)
    public StateResponse updateRoomDescription(@RequestBody RoomDescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(roomDescriptionService.updateRoomDescription(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteRoomDescription", method = RequestMethod.POST)
    public StateResponse deleteRoomDescription(@RequestBody RequestWithId request) {
        StateResponse stateResponse = new StateResponse();
        try {
            roomDescriptionService.deleteRoomDescription(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }
}
