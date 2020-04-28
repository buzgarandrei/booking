package com.example.booking.controllers;

import com.example.booking.requests.HotelDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.HotelDescriptionResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.HotelDescriptionService;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelDescriptionController {

    @Autowired
    HotelDescriptionService hotelDescriptionService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getHotelDescriptions")
    public List<HotelDescriptionResponse> getHotelDescriptions() {
        return hotelDescriptionService.getHotelDescriptions();
    }

    @RequestMapping(value = "/getDescriptionsOfAHotel")
    public List<HotelDescriptionResponse> getDescriptionsOfAHotel(@RequestBody RequestWithId request) {
        return hotelDescriptionService.getDescriptionsOfAHotel(request);
    }

    @RequestMapping(value = "/addHotelDescription", method = RequestMethod.POST)
    public StateResponse addHotelDescriptions(@RequestBody HotelDescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(hotelDescriptionService.addHotelDescriptions(request).isSuccess())
            stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
            e.printStackTrace();
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateHotelDescription", method = RequestMethod.POST)
    public StateResponse updateHotelDescription(@RequestBody HotelDescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(hotelDescriptionService.updateHotelDescription(request).isSuccess())
            stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
            e.printStackTrace();
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteHotelDescription", method = RequestMethod.POST)
    public StateResponse deleteHotelDescription(@RequestBody RequestWithId request) {
        StateResponse stateResponse = new StateResponse();
        try {
            hotelDescriptionService.deleteHotelDescription(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
            e.printStackTrace();
        }
        return stateResponse;
    }
}
