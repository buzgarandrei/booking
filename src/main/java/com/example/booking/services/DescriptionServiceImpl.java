package com.example.booking.services;

import com.example.booking.entities.Description;
import com.example.booking.repositories.DescriptionRepository;
import com.example.booking.requests.DescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.DescriptionResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionServiceImpl implements DescriptionService {

    @Autowired
    DescriptionRepository descriptionRepository;

    @Override
    public List<DescriptionResponse> getDescriptions() {

        return descriptionRepository.getDescriptions();
    }

    @Override
    public Long addDescription(DescriptionRequest request) {
        return descriptionRepository.addDescription(request);
    }

    @Override
    public StateResponse updateDescription(DescriptionRequest request) {

        return descriptionRepository.updateDescription(request);
    }

    @Override
    public void deleteDescription(RequestWithId request) {

        descriptionRepository.deleteDescription(request);
    }

    @Override
    public Description getDescriptionById(RequestWithId idDto) {

        return descriptionRepository.getDescriptionById(idDto);
    }

}
