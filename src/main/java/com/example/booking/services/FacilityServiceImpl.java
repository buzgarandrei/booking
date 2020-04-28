package com.example.booking.services;

import com.example.booking.repositories.FacilitiesRepository;
import com.example.booking.requests.FacilityRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    FacilitiesRepository facilitiesRepository;

    @Override
    public List<FacilityResponse> getFacilities() {
        List<FacilityResponse> responseList = facilitiesRepository.getFacilities();

        return responseList;
    }

    @Override
    public StateResponse addFacility(FacilityRequest request) {

        return facilitiesRepository.addFacility(request);
    }

    @Override
    public StateResponse updateFacility(FacilityRequest request) {

        return facilitiesRepository.updateFacility(request);
    }

    @Override
    public void deleteFacility(RequestWithId request) {

        facilitiesRepository.deleteFacility(request);
    }

    @Override
    public StateResponse addFacilityDescription(RequestWith2Ids request) {
        return facilitiesRepository.addFacilityDescription(request);
    }

    @Override
    public StateResponse deleteFacilityDescription(RequestWith2Ids request) {
        return facilitiesRepository.deleteFacilityDescription(request);
    }
}
