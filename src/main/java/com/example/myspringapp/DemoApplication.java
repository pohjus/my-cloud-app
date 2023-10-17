package com.example.myspringapp;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

import lombok.*;


@SpringBootApplication
@RestController
@RequestMapping("/api/customers")
public class DemoApplication {
    private final List<Customer> customers = new ArrayList<>();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }

    @PostConstruct
    private void addInitialCustomers() {
        customers.add(new Customer(1, "John", "Doe"));
        customers.add(new Customer(2, "Jane", "Smith"));
    }

    @Data
    @AllArgsConstructor
    static class Customer {
        private int id;
        private String firstName;
        private String lastName;
    }
}
