package com.example.booking.repositories;

import com.example.booking.entities.BedType;
import com.example.booking.requests.BedTypeRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.utils.KindOfBed;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BedTypeRepositoryImpl implements BedTypeRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<BedType> getBedTypes() {
        Query query = entityManager.createQuery(" select beds from BedType  beds ", BedType.class);
        List<BedType> bedTypes = query.getResultList();
        return bedTypes;
    }

    @Override
    @Transactional
    public StateResponse addBedType(BedTypeRequest request) {
        StateResponse stateResponse = new StateResponse();
        BedType bedType = new BedType();
        if(request.getKindOfBed() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        bedType.setKindOfBed(KindOfBed.valueOf(request.getKindOfBed()));
        if(request.getNoOfPersons() == 0) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        bedType.setNoOfPersons(request.getNoOfPersons());

        entityManager.persist(bedType);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateBedType(BedTypeRequest request) {
        StateResponse stateResponse = new StateResponse();
        BedType bedType = entityManager.find(BedType.class,request.getId());
        if(bedType == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        if(request.getKindOfBed() != null)
            bedType.setKindOfBed(KindOfBed.valueOf(request.getKindOfBed()));
        if(request.getNoOfPersons() != 0)
            bedType.setNoOfPersons(request.getNoOfPersons());

        entityManager.merge(bedType);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteBedType(RequestWithId request) {
        entityManager.remove(entityManager.find(BedType.class,request.getId().intValue()));
    }
}
