package com.example.booking.controllers;

import com.example.booking.requests.HotelRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.HotelResponse;
import com.example.booking.responses.RoomResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.HotelService;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(path = "/getHotels")
    public List<HotelResponse> getHotels(HttpServletRequest servletRequest) {

        List<HotelResponse> responseList = hotelService.getHotels();

        return responseList;
    }

    @RequestMapping(value = "/addHotel",method = RequestMethod.POST)
    public StateResponse addHotel(HttpServletRequest servletRequest, @RequestBody HotelRequest request) {
        boolean validated = authenticationService.validateTokenAndRole(servletRequest, RoleEnum.OWNER);
        if(!validated) return null;
        StateResponse stateResponse = new StateResponse();
        try {
            if(hotelService.addHotel(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateHotel",method = RequestMethod.POST)
    public StateResponse updateHotel(HttpServletRequest servletRequest, @RequestBody HotelRequest request) {

        StateResponse stateResponse = new StateResponse();
        try {
            if(hotelService.updateHotel(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteHotel",method = RequestMethod.POST)
    public StateResponse deleteHotel(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        StateResponse stateResponse = new StateResponse();
        try {
            hotelService.deleteHotel(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/addHotelFacility",method = RequestMethod.POST)
    public StateResponse addHotelFacility(HttpServletRequest servletRequest, @RequestBody RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        try {
            stateResponse.setSuccess(hotelService.addHotelFacility(request).isSuccess());
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteHotelFacility",method = RequestMethod.POST)
    public StateResponse deleteHotelFacility(HttpServletRequest servletRequest, @RequestBody RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        try {
            stateResponse.setSuccess(hotelService.deleteHotelFacility(request).isSuccess());
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/getHotelFacilities")
    public List<FacilityResponse> getHotelFacilities(@RequestBody RequestWithId request) {
        return hotelService.getHotelFacilities(request);
    }

    @RequestMapping(value = "/getRoomsOfAHotel", method = RequestMethod.POST)
    public List<RoomResponse> getRoomsOfAHotel(@RequestBody RequestWithId request) {
        return hotelService.getRoomsOfAHotel(request);
    }

    @RequestMapping(path = "getHotelsOfOwner", method = RequestMethod.POST)
    public List<HotelResponse> getHotelsOfOwner(HttpServletRequest request) {
        boolean validated = authenticationService.validateTokenAndRole(request,RoleEnum.OWNER);
        if(!validated) return null;
        RequestWithId requestWithId = new RequestWithId();
        requestWithId.setId(authenticationService.getIdUser(request));
        return hotelService.getHotelsOfOwner(requestWithId);
    }



}
