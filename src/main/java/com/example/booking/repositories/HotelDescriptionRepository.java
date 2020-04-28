package com.example.booking.repositories;

import com.example.booking.entities.HotelDescription;
import com.example.booking.requests.HotelDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.StateResponse;

import java.util.List;

public interface HotelDescriptionRepository {
    List<HotelDescription> getHotelDescriptions();

    StateResponse addHotelDescriptions(HotelDescriptionRequest request);

    StateResponse updateHotelDescription(HotelDescriptionRequest request);

    void deleteHotelDescription(RequestWithId request);

    List<HotelDescription> getDescriptionsOfAHotel(RequestWithId request);
}
