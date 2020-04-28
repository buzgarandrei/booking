package com.example.booking.services;

import com.example.booking.entities.BedType;
import com.example.booking.repositories.BedTypeRepository;
import com.example.booking.requests.BedTypeRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.BedTypeResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BedTypeServiceImpl implements BedTypeService {

    @Autowired
    BedTypeRepository bedTypeRepository;


    @Override
    public List<BedTypeResponse> getBedTypes() {
        List<BedType> entities = bedTypeRepository.getBedTypes();
        List<BedTypeResponse> responseList = new ArrayList<>();
        for ( BedType bedType : entities) {
            BedTypeResponse response = new BedTypeResponse();
            response.setKindOfBed(bedType.getKindOfBed().toString());
            response.setNoOfPersons(bedType.getNoOfPersons());
            response.setId((bedType.getId()));

            responseList.add(response);
        }
       return responseList;
    }

    @Override
    public StateResponse addBedType(BedTypeRequest request) {
        return bedTypeRepository.addBedType(request);
    }

    @Override
    public StateResponse updateBedType(BedTypeRequest request) {
        return bedTypeRepository.updateBedType(request);
    }

    @Override
    public void deleteBedType(RequestWithId request) {
        bedTypeRepository.deleteBedType(request);
    }
}
