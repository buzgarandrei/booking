package com.example.booking.controllers;

import com.example.booking.entities.Description;
import com.example.booking.requests.DescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.DescriptionResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.DescriptionService;
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
public class DescriptionController {

    @Autowired
    DescriptionService descriptionService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getDescriptions")
    public List<DescriptionResponse> getDescriptions(HttpServletRequest servletRequest) {
        return descriptionService.getDescriptions();
    }

    @RequestMapping(value = "/addDescription", method = RequestMethod.POST)
    public Long addDescription(HttpServletRequest servletRequest, @RequestBody DescriptionRequest request) {

        return descriptionService.addDescription(request);
    }

    @RequestMapping(value = "/updateDescription", method = RequestMethod.POST)
    public StateResponse updateDescription(HttpServletRequest servletRequest, @RequestBody DescriptionRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(descriptionService.updateDescription(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteDescription", method = RequestMethod.POST)
    public StateResponse deleteDescription(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {
        StateResponse stateResponse = new StateResponse();
        try {
            descriptionService.deleteDescription(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "getDescriptionById", method = RequestMethod.POST)
    public Description getDescriptionById(HttpServletRequest request, @RequestBody RequestWithId idDto) {
        boolean validated = authenticationService.validateTokenAndRole(request, RoleEnum.OWNER);
        if (!validated) return null;
        return descriptionService.getDescriptionById(idDto);
    }
}
