package com.example.booking.services;

import com.example.booking.repositories.UserRepository;
import com.example.booking.requests.AppointmentRequest;
import com.example.booking.requests.SearchRequest;
import com.example.booking.requests.UserRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.SearchResponse;
import com.example.booking.responses.UserResponse;
import com.example.booking.utils.RoleEnum;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserResponse> getUsers() {

        List<UserResponse> responseList = userRepository.getUsers();
        return responseList;
    }

    @Override
    public StateResponse addUser(UserRequest request) {

        return userRepository.addUser(request);
    }

    @Override
    public StateResponse updateUser(UserRequest request) {

        return userRepository.updateUser(request);
    }

    @Override
    public void deleteUser(RequestWithId request) {

        userRepository.deleteUser(request);
    }

    @Override
    public StateResponse makeAdmin(RequestWithId request) {

        return userRepository.makeAdmin(request);
    }

    @Override
    public StateResponse makeOwner(RequestWithId request) {

        return userRepository.makeOwner(request);
    }

    @Override
    public StateResponse makePremiumUser(RequestWithId request) {

        return userRepository.makePremiumUser(request);
    }

    @Override
    public UserResponse login(UserRequest userRequest) {

        return userRepository.login(userRequest);
    }

    @Override
    public RoleEnum getUserRole(Long id) {
        return userRepository.getUserRole(id);
    }

    @Override
    public List<SearchResponse> search(SearchRequest request) throws ParseException {
        return userRepository.search(request);
    }

    @Override
    public AppointmentResponse makeAppointment(AppointmentRequest request) throws ParseException {
        return userRepository.makeAppointment(request);
    }

    @Override
    public List<AppointmentResponse> getUserAppointments(Long idUser) {
        return userRepository.getUserAppointments(idUser);
    }

    @Override
    public StateResponse acceptAppointment(RequestWithId requestWithId) {
        return userRepository.acceptAppointment(requestWithId);
    }

    @Override
    public StateResponse refuseAppointment(RequestWithId requestWithId) {
        return userRepository.refuseAppointment(requestWithId);
    }

    @Override
    public StateResponse makeBasicUser(RequestWithId requestWithId) {

        return userRepository.makeBasicUser(requestWithId);
    }
}
