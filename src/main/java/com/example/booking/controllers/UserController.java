package com.example.booking.controllers;

import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.requests.UserRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.SearchResponse;
import com.example.booking.responses.UserResponse;
import com.example.booking.services.AuthenticationService;
import com.example.booking.services.UserService;
import com.example.booking.utils.Language;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/getUsers")
    public List<UserResponse> getUsers(HttpServletRequest request) {

        boolean validated = authenticationService.validateTokenAndRole(request, RoleEnum.ADMIN);
        if(!validated)
            return null;
        List<UserResponse> responseList = userService.getUsers();
        return responseList;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public StateResponse addUser(HttpServletRequest servletRequest, @RequestBody UserRequest request) {

        StateResponse stateResponse = new StateResponse();
        try {
            if(userService.addUser(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public StateResponse updateUser(HttpServletRequest servletRequest, @RequestBody UserRequest request) {

        StateResponse stateResponse = new StateResponse();
        try {
            if(userService.updateUser(request).isSuccess())
                stateResponse.setSuccess(true);
            else stateResponse.setSuccess(false);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public StateResponse deleteUser(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        StateResponse stateResponse = new StateResponse();
        try {
            userService.deleteUser(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/makeAdmin", method = RequestMethod.POST)
    public StateResponse makeAdmin(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        boolean validated = authenticationService.validateTokenAndRole(servletRequest,RoleEnum.ADMIN);
        if (!validated) return null;
        StateResponse stateResponse = new StateResponse();

        try {
            userService.makeAdmin(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "makeBasicUser", method = RequestMethod.POST)
    public StateResponse makeBasicUser(HttpServletRequest request, @RequestBody RequestWithId requestWithId) {
        boolean validated = authenticationService.validateTokenAndRole(request,RoleEnum.ADMIN);
        if (!validated) return null;
        return userService.makeBasicUser(requestWithId);
    }

    @RequestMapping(value = "/makeOwner", method = RequestMethod.POST)
    public StateResponse makeOwner(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        boolean validated = authenticationService.validateTokenAndRole(servletRequest,RoleEnum.ADMIN);
        if (!validated) return null;
        StateResponse stateResponse = new StateResponse();
        try {
            userService.makeOwner(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/makePremiumUser", method = RequestMethod.POST)
    public StateResponse makePremiumUser(HttpServletRequest servletRequest, @RequestBody RequestWithId request) {

        boolean validated = authenticationService.validateTokenAndRole(servletRequest,RoleEnum.ADMIN);
        if (!validated) return null;
        StateResponse stateResponse = new StateResponse();

        try {
            userService.makePremiumUser(request);
            stateResponse.setSuccess(true);
        }
        catch (Exception e) {
            e.printStackTrace();
            stateResponse.setSuccess(false);
        }
        return stateResponse;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public UserResponse login(HttpServletRequest httpServletRequest, @RequestBody UserRequest userRequest) {

        UserResponse response = userService.login(userRequest);

        if(response.getId() != null  && response.getRoleEnum() != null) {
            String token;
            token = authenticationService.registerLogin(response.getId(), userRequest.getEmail(), response.getRoleEnum());
            response.setToken(token);
            response.setEmail(userRequest.getEmail());
        }

        return response;
    }

    @RequestMapping(value = "logout")
    public StateResponse logout(HttpServletRequest request) {
        return authenticationService.logout(request);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public List<SearchResponse> search(Locale locale, @RequestBody SearchRequest request) throws ParseException {
        request.setLanguage(Language.valueOf(locale.getLanguage().toUpperCase()));
        return userService.search(request);
    }

    @RequestMapping(value = "/makeAppointment", method = RequestMethod.POST)
    public AppointmentResponse makeAppointment(HttpServletRequest servletRequest, @RequestBody AppointmentRequest request) throws ParseException {

        boolean validated1 = authenticationService.validateTokenAndRole(servletRequest, RoleEnum.PREMIUM_USER);
        boolean validated2 = authenticationService.validateTokenAndRole(servletRequest, RoleEnum.BASIC_USER);
        if(!validated1 && !validated2) return null;
        Long idUser = authenticationService.getIdUser(servletRequest);
        if(idUser == null) return null;
        request.setUserId(idUser);

        return userService.makeAppointment(request);
    }
    @RequestMapping(value = "getUserAppointments", method = RequestMethod.POST)
    public List<AppointmentResponse> getUserAppointments(HttpServletRequest request) {
        boolean validated1 = authenticationService.validateTokenAndRole(request,RoleEnum.BASIC_USER);
        boolean validated2 = authenticationService.validateTokenAndRole(request,RoleEnum.PREMIUM_USER);
        if(!validated1 && !validated2) return null;
        Long idUser = authenticationService.getIdUser(request);
        if(idUser == null) return null;
        return userService.getUserAppointments(idUser);

    }

    @RequestMapping( value = "acceptAppointment", method = RequestMethod.POST)
    public StateResponse acceptAppointment(HttpServletRequest request, @RequestBody RequestWithId requestWithId) {
        boolean validated = authenticationService.validateTokenAndRole(request,RoleEnum.OWNER);
        if (!validated) return  null;
        return userService.acceptAppointment(requestWithId);

    }

    @RequestMapping(value = "refuseAppointment", method = RequestMethod.POST)
    public StateResponse refuseAppointment (HttpServletRequest request, @RequestBody RequestWithId requestWithId) {
        boolean validated = authenticationService.validateTokenAndRole(request,RoleEnum.OWNER);
        if (!validated) return null;
        return userService.refuseAppointment(requestWithId);
    }

}
