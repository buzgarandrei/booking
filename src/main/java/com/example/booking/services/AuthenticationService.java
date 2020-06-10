package com.example.booking.services;

import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {

    public String registerLogin(Long id, String name,RoleEnum roleEnum);

    public boolean validateTokenAndRole(HttpServletRequest servletRequest, RoleEnum roleEnumDesired);

    public Long getUserIdByToken(HttpServletRequest httpServletRequest);

    public StateResponse logout(HttpServletRequest servletRequest);

    public Long getIdUser(HttpServletRequest request);
}
