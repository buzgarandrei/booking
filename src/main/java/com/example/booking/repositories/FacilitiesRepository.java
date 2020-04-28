package com.example.booking.repositories;

import com.example.booking.requests.FacilityRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface FacilitiesRepository {
    List<FacilityResponse> getFacilities();

    StateResponse addFacility(FacilityRequest request);

    StateResponse updateFacility(FacilityRequest request);

    void deleteFacility(RequestWithId request);

    StateResponse addFacilityDescription(RequestWith2Ids request);

    StateResponse deleteFacilityDescription(RequestWith2Ids request);
}
