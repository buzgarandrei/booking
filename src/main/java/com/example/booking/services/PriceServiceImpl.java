package com.example.booking.services;

import com.example.booking.repositories.PriceRepository;
import com.example.booking.requests.PriceRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.PriceResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public List<PriceResponse> getPrices() {

        return priceRepository.getPrices();
    }

    @Override
    public StateResponse addPrice(PriceRequest request) throws ParseException {

        return priceRepository.addPrice(request);
    }

    @Override
    public StateResponse updatePrice(PriceRequest request) throws ParseException {

        return priceRepository.updatePrice(request);
    }

    @Override
    public void deletePrice(RequestWithId request) {

        priceRepository.deletePrice(request);

    }
}
