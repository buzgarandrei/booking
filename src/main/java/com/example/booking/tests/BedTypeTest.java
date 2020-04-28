package com.example.booking.tests;

import com.example.booking.entities.BedType;
import com.example.booking.utils.KindOfBed;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BedTypeTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void addBedType() {

        BedType bedType = new BedType();
        bedType.setKindOfBed(KindOfBed.MATRIMONIAL);
        bedType.setNoOfPersons(2);

        entityManager.persist(bedType);

        BedType bedType1 = new BedType();
        bedType1.setNoOfPersons(1);
        bedType1.setKindOfBed(KindOfBed.SINGLESIZE);

        entityManager.persist(bedType1);
    }
}
