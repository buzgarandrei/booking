package com.example.booking.services;

import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.requests.UserRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.SearchResponse;
import com.example.booking.responses.UserResponse;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;

import java.text.ParseException;
import java.util.List;

public interface UserService {
    List<UserResponse> getUsers();

    StateResponse addUser(UserRequest request);

    StateResponse updateUser(UserRequest request);

    void deleteUser(RequestWithId request);

    StateResponse makeAdmin(RequestWithId request);

    StateResponse makeOwner(RequestWithId request);

    StateResponse makePremiumUser(RequestWithId request);

    UserResponse login(UserRequest userRequest);

    public RoleEnum getUserRole(Long id);

    public List<SearchResponse> search(SearchRequest request) throws ParseException;

    public AppointmentResponse makeAppointment(AppointmentRequest request) throws ParseException;

    List<AppointmentResponse> getUserAppointments(Long idUser);

    StateResponse acceptAppointment(RequestWithId requestWithId);

    StateResponse refuseAppointment(RequestWithId requestWithId);

    StateResponse makeBasicUser(RequestWithId requestWithId);
}
