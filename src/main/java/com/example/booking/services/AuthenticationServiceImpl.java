package com.example.booking.services;

import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import com.example.booking.utils.UserSession;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private static final String TOKEN = "TOKEN";
    private static final boolean VALIDATION_IS_ACTIVE = false;

    private static final Map<String, UserSession> userSessions = new HashMap<String,UserSession>();

    public String registerLogin(Long id, String email,RoleEnum roleEnum) {

        UserSession userSession = new UserSession();
        userSession.setId(id);
        userSession.setEmail(email);
        userSession.setRoleEnum(roleEnum);
        String token = UUID.randomUUID().toString().replace("-","");
        userSession.setToken(token);

        userSessions.put(token,userSession);
        return token;
    }

    public boolean validateTokenAndRole(HttpServletRequest servletRequest, RoleEnum roleEnumDesired) {

        if(VALIDATION_IS_ACTIVE == false)
            return true;
        String token = servletRequest.getHeader(TOKEN);
        if(token == null)
            return false;
        UserSession userSession = userSessions.get(token);
        if(userSession == null)
            return false;

        if(roleEnumDesired == null) return true;
        if(userSession.getToken() == RoleEnum.ADMIN.toString())
            return true;
        if(roleEnumDesired != userSession.getRoleEnum())
            return false;
        return true;
    }

    public Long getUserIdByToken(HttpServletRequest httpServletRequest) {

        String token = httpServletRequest.getHeader(TOKEN);
        if(token == null) return null;

        UserSession userSession = userSessions.get(token);
        if(userSession == null) return null;

        if(userSession.getId() == null) return null;

        return userSession.getId();
    }

    @Override
    public StateResponse logout(HttpServletRequest servletRequest) {

        StateResponse stateResponse = new StateResponse();
        String token = servletRequest.getHeader(TOKEN);

        if(userSessions.remove(token) == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        stateResponse.setSuccess(true);
        return stateResponse;
    }

}
