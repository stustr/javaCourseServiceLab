package com.codeclan.example.BookingSystem.controllers;

import com.codeclan.example.BookingSystem.models.Booking;
import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value = "/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(
            @RequestParam(required = false, name =
                    "date") String date)
    {
        if (date != null){
            return new ResponseEntity<>(bookingRepository.findBookingByDate(date), HttpStatus.OK);
        }

        return new ResponseEntity<>(bookingRepository.findAll()
                , HttpStatus.OK);
    }

}
