package com.example.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Arrays;
import java.util.List;


@EnableTransactionManagement
@EnableSpringConfigured
@EntityScan(basePackages = {"com.example.booking.entities"})
@EnableJpaRepositories("com.example.booking.repositories")
@SpringBootApplication
public class BookingApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(BookingApplication.class, args);
        /*List<String> stringList = Arrays.asList(context.getBeanDefinitionNames());
        for (String s : stringList) {
            System.out.println(s);
        }*/
    }

}
