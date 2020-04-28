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
    public void makeAdmin(RequestWithId request) {

        userRepository.makeAdmin(request);
    }

    @Override
    public void makeOwner(RequestWithId request) {

        userRepository.makeOwner(request);
    }

    @Override
    public void makePremiumUser(RequestWithId request) {

        userRepository.makePremiumUser(request);
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
}
