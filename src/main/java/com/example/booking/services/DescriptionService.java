package com.example.booking.services;

import com.example.booking.requests.DescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.DescriptionResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface DescriptionService {
    List<DescriptionResponse> getDescriptions();

    StateResponse addDescription(DescriptionRequest request);

    StateResponse updateDescription(DescriptionRequest request);

    void deleteDescription(RequestWithId request);
}
