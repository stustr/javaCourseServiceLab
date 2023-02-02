package com.codeclan.example.BookingSystem.controllers;

import com.codeclan.example.BookingSystem.models.Customer;
import com.codeclan.example.BookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(required = false, name =
                    "course") String course)
    {
        if (course != null){
            return new ResponseEntity<>(customerRepository.findCustomerByBookingsCourseName(course), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

}
