package com.example.booking.repositories;

import com.example.booking.entities.Description;
import com.example.booking.entities.Facility;
import com.example.booking.requests.FacilityRequest;
import com.example.booking.requests.RequestWith2Ids;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.FacilityResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FacilitiesRepositoryImpl implements FacilitiesRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<FacilityResponse> getFacilities() {

        Query query = entityManager.createQuery("select fac from Facility  fac", Facility.class);
        List<Facility> facilities = query.getResultList();
        List<FacilityResponse> responseList = new ArrayList<>();

        for (Facility facility : facilities) {
            FacilityResponse response = new FacilityResponse();
            response.setSVG(facility.getSVG());
            response.setFacilityName(facility.getFacilityName());
            response.setFacilityType(facility.getFacilityType());
            response.setId(facility.getId());

            responseList.add(response);
        }

        return responseList;
    }

    @Override
    @Transactional
    public Long addFacility(FacilityRequest request) {

        if (request.getSVG() == null || request.getFacilityType() == null || request.getFacilityName() == null) {
            return null;
        }
        Facility facility = new Facility();
        facility.setSVG(request.getSVG());
        facility.setFacilityType(request.getFacilityType());
        facility.setFacilityName(request.getFacilityName());

        entityManager.persist(facility);
        entityManager.flush();
        return facility.getId();
    }

    @Override
    @Transactional
    public StateResponse updateFacility(FacilityRequest request) {

        StateResponse stateResponse = new StateResponse();
        Facility facility = entityManager.find(Facility.class, request.getId());
        if (facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        if (request.getFacilityName() != null) facility.setFacilityName(request.getFacilityName());
        if (request.getFacilityType() != null) facility.setFacilityType(request.getFacilityType());
        if (request.getSVG() != null) facility.setSVG(request.getSVG());

        entityManager.merge(facility);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteFacility(RequestWithId request) {

        Facility facility = entityManager.find(Facility.class, request.getId());
        entityManager.remove(facility);
    }

    @Override
    @Transactional
    public StateResponse addFacilityDescription(RequestWith2Ids request) {
        StateResponse stateResponse = new StateResponse();
        if (request.getId1() == null || request.getId2() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Facility facility = entityManager.find(Facility.class, request.getId1());
        if (facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Description description = entityManager.find(Description.class, request.getId2());
        if (description == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }

        facility.getDescriptionList().add(description);
        entityManager.merge(facility);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse deleteFacilityDescription(RequestWith2Ids request) {

        StateResponse stateResponse = new StateResponse();
        if (request.getId1() == null || request.getId2() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Facility facility = entityManager.find(Facility.class, request.getId1());
        if (facility == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        Description description = entityManager.find(Description.class, request.getId2());
        if (description == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        if(facility.getDescriptionList().contains(description) == false) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        facility.getDescriptionList().remove(description);
        entityManager.merge(facility);
        stateResponse.setSuccess(true);
        return stateResponse;
    }
}
