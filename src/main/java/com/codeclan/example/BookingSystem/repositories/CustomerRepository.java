package com.codeclan.example.BookingSystem.repositories;

import com.codeclan.example.BookingSystem.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseName(String name);

    List<Customer> findCustomerByTownAndBookingsCourseName(String townName, String courseName);

    List<Customer> findCustomerByAgeGreaterThanAndTownAndBookingsCourseName(Integer age, String townName, String courseName);

}
