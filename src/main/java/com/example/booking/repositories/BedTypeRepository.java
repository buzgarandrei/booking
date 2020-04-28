package com.example.booking.repositories;

import com.example.booking.entities.BedType;
import com.example.booking.requests.BedTypeRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface BedTypeRepository {
    List<BedType> getBedTypes();

    StateResponse addBedType(BedTypeRequest request);

    StateResponse updateBedType(BedTypeRequest request);

    void deleteBedType(RequestWithId request);
}
