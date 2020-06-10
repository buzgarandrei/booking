package com.example.booking.tests;

import com.example.booking.entities.User;
import com.example.booking.utils.RoleEnum;
import net.bytebuddy.description.modifier.Ownership;
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
        user.setRoleEnum(RoleEnum.BASIC_USER);
        user.setName("Buzgar Andrei-Valentin");
        user.setEmail("buzgarandrei@gmail.com");
        user.setPassword("123");

        entityManager.persist(user);

        User user1 = new User();
        user1.setEmail("billthompson@yahoo.com");
        user1.setPassword("124");
        user1.setName("Bill Thomson");
        user1.setRoleEnum(RoleEnum.PREMIUM_USER);
        entityManager.persist(user1);

        User user2 = new User();
        user2.setRoleEnum(RoleEnum.OWNER);
        user2.setEmail("comanvasile@gmail.com");
        user2.setName("Coman Vasile");
        user2.setPassword("125");
        entityManager.persist(user2);

        User user3 = new User();
        user3.setPassword("126");
        user3.setName("Szolt");
        user3.setEmail("szolt@gmail.com");
        user3.setRoleEnum(RoleEnum.ADMIN);
        entityManager.persist(user3);

        User user4 = new User();
        user4.setRoleEnum(RoleEnum.OWNER);
        user4.setEmail("cheresvlad@gmail.com");
        user4.setName("Cheres Vlad");
        user4.setPassword("127");
        entityManager.persist(user4);

    }
}
