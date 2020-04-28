package com.example.booking.controllers;

import com.example.booking.requests.RoomBedListRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.RoomBedListResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.RoomBedListService;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomBedListController {

    @Autowired
    RoomBedListService roomBedListService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getListOfAllBeds")
    public List<RoomBedListResponse> getListOfAllBeds() {
        return roomBedListService.getListOfAllBeds();
    }

    @RequestMapping(value = "/addBedToARoom", method = RequestMethod.POST)
    public StateResponse addBedToARoom(@RequestBody RoomBedListRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(roomBedListService.addBedToARoom(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateBedOfARoom", method = RequestMethod.POST)
    public StateResponse updateBedOfARoom(@RequestBody RoomBedListRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(roomBedListService.updateBedOfARoom(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false );
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteBedOfARoom", method = RequestMethod.POST)
    public StateResponse deleteBedOfARoom(@RequestBody RequestWithId request) {
        StateResponse stateResponse = new StateResponse();
        try {
            roomBedListService.deleteBedOfARoom(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/getBedsOfARoom")
    public List<RoomBedListResponse> getBedsOfARoom(@RequestBody RequestWithId request) {
        return roomBedListService.getBedsOfARoom(request);
    }

}
