package com.example.booking.services;

import com.example.booking.entities.HotelDescription;
import com.example.booking.repositories.HotelDescriptionRepository;
import com.example.booking.requests.HotelDescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.HotelDescriptionResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelDescriptionServiceImpl implements HotelDescriptionService {

    @Autowired
    HotelDescriptionRepository hotelDescriptionRepository;

    @Override
    public List<HotelDescriptionResponse> getHotelDescriptions() {
        List<HotelDescription> entities = hotelDescriptionRepository.getHotelDescriptions();
        List<HotelDescriptionResponse> responseList = new ArrayList<>();
        for (HotelDescription entity : entities) {
            HotelDescriptionResponse response = new HotelDescriptionResponse();
            response.setDescriptionId(entity.getDescription().getId());
            response.setHotelId(entity.getHotel().getId());
            response.setHotelDescriptionType(entity.getHotelDescriptionType().toString());
            response.setId(entity.getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public StateResponse addHotelDescriptions(HotelDescriptionRequest request) {
        return hotelDescriptionRepository.addHotelDescriptions(request);
    }

    @Override
    public StateResponse updateHotelDescription(HotelDescriptionRequest request) {
        return hotelDescriptionRepository.updateHotelDescription(request);
    }

    @Override
    public void deleteHotelDescription(RequestWithId request) {
        hotelDescriptionRepository.deleteHotelDescription(request);
    }

    @Override
    public List<HotelDescriptionResponse> getDescriptionsOfAHotel(RequestWithId request) {
        List<HotelDescription> entities = hotelDescriptionRepository.getDescriptionsOfAHotel(request);
        List<HotelDescriptionResponse> responseList = new ArrayList<>();
        for (HotelDescription entity : entities) {
            HotelDescriptionResponse response = new HotelDescriptionResponse();
            response.setDescriptionId(entity.getDescription().getId());
            response.setHotelId(entity.getHotel().getId());
            response.setHotelDescriptionType(entity.getHotelDescriptionType().toString());
            response.setId(entity.getId());

            responseList.add(response);
        }
        return responseList;

    }
}
