package com.example.booking.controllers;

import com.example.booking.requests.OfferRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.OfferResponse;
import com.example.booking.services.OfferService;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OfferController {

    @Autowired
    OfferService offerService;

    @RequestMapping(value = "/getOffers")
    public List<OfferResponse> getOffers() {
        return offerService.getOffers();
    }

    @RequestMapping(value = "/addOffer",method = RequestMethod.POST)
    public StateResponse addOffer(@RequestBody OfferRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(offerService.addOffer(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateOffer",method = RequestMethod.POST)
    public StateResponse updateOffer(@RequestBody OfferRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(offerService.updateOffer(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteOffer", method = RequestMethod.POST)
    public StateResponse deleteOffer(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        StateResponse stateResponse = new StateResponse();
        try {
            offerService.deleteOffer(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }


}
