package com.example.booking.services;

import com.example.booking.requests.BedTypeRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.BedTypeResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface BedTypeService {
    List<BedTypeResponse> getBedTypes();

    StateResponse addBedType(BedTypeRequest request);

    StateResponse updateBedType(BedTypeRequest request);

    void deleteBedType(RequestWithId request);
}
