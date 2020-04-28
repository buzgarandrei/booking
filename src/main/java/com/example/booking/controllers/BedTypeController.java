package com.example.booking.controllers;

import com.example.booking.requests.BedTypeRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.BedTypeResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.BedTypeService;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BedTypeController {

    @Autowired
    BedTypeService bedTypeService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping("/getBedTypes")
    public List<BedTypeResponse> getBedTypes() {

        return bedTypeService.getBedTypes();

    }

    @RequestMapping(value = "/addBedType", method = RequestMethod.POST)
    public StateResponse addBedType(@RequestBody BedTypeRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(bedTypeService.addBedType(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateBedType", method = RequestMethod.POST)
    public StateResponse updateBedType(@RequestBody BedTypeRequest request) {
        StateResponse stateResponse = new StateResponse();
        try {
            if(bedTypeService.updateBedType(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteBedType", method = RequestMethod.POST)
    public StateResponse deleteBedType(@RequestBody RequestWithId request) {
        StateResponse stateResponse = new StateResponse();
        try {
            bedTypeService.deleteBedType(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }
}
