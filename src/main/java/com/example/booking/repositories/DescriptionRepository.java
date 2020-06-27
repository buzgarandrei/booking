package com.example.booking.repositories;

import com.example.booking.entities.Description;
import com.example.booking.requests.DescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.DescriptionResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface DescriptionRepository {
    List<DescriptionResponse> getDescriptions();

    Long addDescription(DescriptionRequest request);

    StateResponse updateDescription(DescriptionRequest request);

    void deleteDescription(RequestWithId request);

    Description getDescriptionById(RequestWithId idDto);
}
