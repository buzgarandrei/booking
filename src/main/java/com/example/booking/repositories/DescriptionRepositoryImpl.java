package com.example.booking.repositories;

import com.example.booking.entities.Description;
import com.example.booking.requests.DescriptionRequest;
import com.example.booking.requests.special_requests.RequestWithId;
import com.example.booking.responses.DescriptionResponse;
import com.example.booking.utils.StateResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DescriptionRepositoryImpl implements DescriptionRepository {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public List<DescriptionResponse> getDescriptions() {

        Query query = entityManager.createQuery("select d from Description d  ", Description.class);
        List<Description> descriptionList = query.getResultList();
        List<DescriptionResponse> responseList = new ArrayList<>();
        for (Description description : descriptionList) {

            DescriptionResponse response = new DescriptionResponse();
            response.setId(description.getId());
            response.setLanguage(description.getLanguage());
            response.setText(description.getText());

            responseList.add(response);
        }
        return responseList;
    }

    @Override
    @Transactional
    public StateResponse addDescription(DescriptionRequest request) {

        StateResponse stateResponse = new StateResponse();
        Description description = new Description();
        if(request.getLanguage() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        description.setLanguage(request.getLanguage());
        if(request.getText() == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        description.setText(request.getText());

        entityManager.persist(description);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public StateResponse updateDescription(DescriptionRequest request) {

        StateResponse stateResponse = new StateResponse();
        Description description = entityManager.find(Description.class, request.getId());
        if(description == null) {
            stateResponse.setSuccess(false);
            return stateResponse;
        }
        if(request.getLanguage() != null) description.setLanguage(request.getLanguage());
        if(request.getText() != null) description.setText(request.getText());

        entityManager.merge(description);
        stateResponse.setSuccess(true);
        return stateResponse;
    }

    @Override
    @Transactional
    public void deleteDescription(RequestWithId request) {

        Description description = entityManager.find(Description.class, request.getId());

        entityManager.remove(description);
    }
}
