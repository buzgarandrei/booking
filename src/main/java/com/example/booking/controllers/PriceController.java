package com.example.booking.controllers;

import com.example.booking.requests.PriceRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.PriceResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.PriceService;
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
public class PriceController {

    @Autowired
    PriceService priceService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getPrices")
    public List<PriceResponse> getPrices(HttpServletRequest servletRequest) {

        return priceService.getPrices();
    }

    @RequestMapping(value = "/addPrice", method = RequestMethod.POST)
    public StateResponse addPrice(HttpServletRequest servletRequest, @RequestBody PriceRequest request) {

        boolean validated = authenticationService.validateTokenAndRole(servletRequest, RoleEnum.OWNER);
        if(!validated) return  null;
        StateResponse stateResponse = new StateResponse();
        try {
            if(priceService.addPrice(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updatePrice", method = RequestMethod.POST)
    public StateResponse updatePrice(HttpServletRequest servletRequest, @RequestBody PriceRequest request) {

        StateResponse stateResponse = new StateResponse();
        try {
            if(priceService.updatePrice(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deletePrice", method = RequestMethod.POST)
    public StateResponse deletePrice(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        StateResponse stateResponse = new StateResponse();
        try {
            priceService.deletePrice(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }
}
