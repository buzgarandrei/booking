package com.example.booking.controllers;

import com.example.booking.requests.FacilityRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.FacilityService;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;

@RestController
public class FacilityController {

    @Autowired
    FacilityService facilityService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "getFacilities")
    public List<FacilityResponse> getFacilities(HttpServletRequest servletRequest) {

        List<FacilityResponse> responseList = facilityService.getFacilities();

        return responseList;
    }

    @RequestMapping(value = "/addFacility", method = RequestMethod.POST)
    public StateResponse addFacility(HttpServletRequest servletRequest, @RequestBody FacilityRequest request) {

        //Locale locale = new Locale("fr");
        //WebUtils.setSessionAttribute(servletRequest, SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
        StateResponse stateResponse = new StateResponse();
        try {
            if(facilityService.addFacility(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateFacility", method = RequestMethod.POST)
    public StateResponse updateFacility(HttpServletRequest servletRequest, @RequestBody FacilityRequest request) {

        StateResponse stateResponse = new StateResponse();
        try {
            if(facilityService.updateFacility(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteFacility", method = RequestMethod.POST)
    public StateResponse deleteFacility(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        StateResponse stateResponse = new StateResponse();
        try {
            facilityService.deleteFacility(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/addFacilityDescription",method = RequestMethod.POST)
    public StateResponse addFacilityDescription (@RequestBody RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        try {
            stateResponse.setSuccess(facilityService.addFacilityDescription(request).isSuccess());
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteFacilityDescription",method = RequestMethod.POST)
    public StateResponse deleteFacilityDescription (@RequestBody RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        try {
            stateResponse.setSuccess(facilityService.deleteFacilityDescription(request).isSuccess());
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

}
