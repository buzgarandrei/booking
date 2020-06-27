package com.example.booking.controllers;

import com.example.booking.requests.PriceRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.RoomRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.PriceResponse;
import com.example.booking.responses.RoomResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.RoomService;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.util.Enumeration;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    RoomService roomService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getRooms")
    public List<RoomResponse> getRooms(HttpServletRequest servletRequest) {

        boolean validated = authenticationService.validateTokenAndRole(servletRequest, RoleEnum.ADMIN);
        if(!validated)
            return null;
        return roomService.getRooms();
    }

    @RequestMapping(value = "/addRoom", method = RequestMethod.POST)
    public StateResponse addRoom(HttpServletRequest servletRequest, @RequestBody RoomRequest roomRequest) {

        boolean validated = authenticationService.validateTokenAndRole(servletRequest,RoleEnum.OWNER);
        if(!validated) return null;
        StateResponse stateResponse = new StateResponse();
        try {
            if(roomService.addRoom(roomRequest).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateRoom", method = RequestMethod.POST)
    public StateResponse updateRoom(HttpServletRequest servletRequest, @RequestBody RoomRequest roomRequest) {

        StateResponse stateResponse = new StateResponse();
        try {
            if(roomService.updateRoom(roomRequest).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteRoom", method = RequestMethod.POST)
    public StateResponse deleteRoom(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        StateResponse stateResponse = new StateResponse();
        try {
            roomService.deleteRoom(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/addRoomFacility", method = RequestMethod.POST)
    public StateResponse addRoomFacility(@RequestBody RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        try {
            stateResponse.setSuccess(roomService.addRoomFacility(request).isSuccess());
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteRoomFacility", method = RequestMethod.POST)
    public StateResponse deleteRoomFacility(@RequestBody RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        try {
            stateResponse.setSuccess(roomService.deleteRoomFacility(request).isSuccess());
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/getRoomFacilities")
    public List<FacilityResponse> getRoomFacilities(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {
        boolean validated = authenticationService.validateTokenAndRole(servletRequest,RoleEnum.OWNER);
        if (!validated) return null;
        return roomService.getRoomFacilities(request);
    }

    @RequestMapping(value = "getPricesOfRoom", method = RequestMethod.POST)
    public List<PriceResponse> getPricesOfRoom(HttpServletRequest sr, @RequestBody RequestWithId request) {
        boolean validateOwner = authenticationService.validateTokenAndRole(sr, RoleEnum.OWNER);
        boolean validateAdmin = authenticationService.validateTokenAndRole(sr, RoleEnum.ADMIN);
        if(!validateAdmin && !validateOwner) return null;
        return roomService.getPricesOfRoom(request);
    }
}
