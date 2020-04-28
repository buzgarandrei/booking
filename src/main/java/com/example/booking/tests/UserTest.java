package com.example.booking.tests;

import com.example.booking.entities.User;
import com.example.booking.utils.RoleEnum;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserTest {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void populateUsers() {

        User user = new User();
        user.setRoleEnum(RoleEnum.ADMIN);
        user.setName("Buzgar Andrei-Valentin");
        user.setEmail("buzgarandrei@gmail.com");
        user.setPassword("123");

        entityManager.persist(user);

        User user1 = new User();
        user1.setEmail("mockUser@gmail.com");
        user1.setPassword("124");
        user1.setName("Mock User");
        user1.setRoleEnum(RoleEnum.PREMIUM_USER);
        entityManager.persist(user1);
    }
}
