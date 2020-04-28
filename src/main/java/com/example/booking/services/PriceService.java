package com.example.booking.services;

import com.example.booking.requests.PriceRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.PriceResponse;
import com.example.booking.utils.StateResponse;

import java.text.ParseException;
import java.util.List;

public interface PriceService {
    List<PriceResponse> getPrices();

    StateResponse addPrice(PriceRequest request) throws ParseException;

    StateResponse updatePrice(PriceRequest request) throws ParseException;

    void deletePrice(RequestWithId request);
}
