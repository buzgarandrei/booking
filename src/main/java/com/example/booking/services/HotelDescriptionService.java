package com.example.booking.services;

import com.example.booking.requests.HotelDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.HotelDescriptionResponse;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface HotelDescriptionService {
    List<HotelDescriptionResponse> getHotelDescriptions();

    StateResponse addHotelDescriptions(HotelDescriptionRequest request);

    StateResponse updateHotelDescription(HotelDescriptionRequest request);

    void deleteHotelDescription(RequestWithId request);

    List<HotelDescriptionResponse> getDescriptionsOfAHotel(RequestWithId request);
}
