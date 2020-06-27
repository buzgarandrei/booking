package com.example.booking.services;

import com.example.booking.entities.Facility;
import com.example.booking.entities.Room;
import com.example.booking.repositories.HotelRepository;
import com.example.booking.requests.HotelRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.AppointmentResponse;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.responses.HotelResponse;
import com.example.booking.responses.RoomResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public List<HotelResponse> getHotels() {

        List<HotelResponse> responseList = hotelRepository.getHotels();

        return responseList;
    }

    @Override
    public StateResponse addHotel(HotelRequest request) {

        return hotelRepository.addHotel(request);
    }

    @Override
    public StateResponse updateHotel(HotelRequest request) {

        return hotelRepository.updateHotel(request);
    }

    @Override
    public void deleteHotel(RequestWithId request) {

        hotelRepository.deleteHotel(request);
    }

    @Override
    public StateResponse addHotelFacility(RequestWith2Ids request) {
        return hotelRepository.addHotelFacility(request);
    }

    @Override
    public StateResponse deleteHotelFacility(RequestWith2Ids request) {
        return hotelRepository.deleteHotelFacility(request);
    }

    @Override
    public List<FacilityResponse> getHotelFacilities(RequestWithId request) {
        List<Facility> entities = hotelRepository.getHotelFacilities(request);
        List<FacilityResponse> responseList = new ArrayList<>();
        for (Facility entity : entities) {
            FacilityResponse response = new FacilityResponse();
            response.setId(entity.getId());
            response.setFacilityType(entity.getFacilityType());
            response.setSVG(entity.getSVG());
            response.setFacilityName(entity.getFacilityName());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<RoomResponse> getRoomsOfAHotel(RequestWithId request) {
        List<Room> roomList = hotelRepository.getRoomsOfAHotel(request);
        List<RoomResponse> responseList = new ArrayList<>();
        for (Room room : roomList) {
            RoomResponse response = new RoomResponse();
            response.setAvailable(room.isAvailable());
            response.setNrOfKids(room.getNrOfKids());
            response.setNrOfAdults(room.getNrOfAdults());
            response.setId(room.getId());
            if(room.getHotel() != null)
                response.setIdHotel(room.getHotel().getId());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    public List<HotelResponse> getHotelsOfOwner(RequestWithId requestWithId) {
        return hotelRepository.getHotelsOfOwner(requestWithId);
    }

    @Override
    public List<AppointmentResponse> getAppointmentsAtAHotel(Long idUser) {

        return hotelRepository.getAppointmentsAtAHotel(idUser);
    }
}
