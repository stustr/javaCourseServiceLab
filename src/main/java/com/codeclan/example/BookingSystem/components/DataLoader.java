package com.codeclan.example.BookingSystem.components;

import com.codeclan.example.BookingSystem.models.Booking;
import com.codeclan.example.BookingSystem.models.Course;
import com.codeclan.example.BookingSystem.models.Customer;
import com.codeclan.example.BookingSystem.models.StarRating;
import com.codeclan.example.BookingSystem.repositories.BookingRepository;
import com.codeclan.example.BookingSystem.repositories.CourseRepository;
import com.codeclan.example.BookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Profile("!test")
//@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Customer jack = new Customer("jack", "Edinburgh",
                18);
        customerRepository.save(jack);

        Customer jill = new Customer("jill", "Glasgow", 91);
        customerRepository.save(jill);

        Course coding = new Course("coding", "Leith",
                StarRating.FIVE);
        courseRepository.save(coding);
        Course maths = new Course("maths", "Stuttgart",
                StarRating.ONE);
        courseRepository.save(maths);

        Booking JackBooking =
                new Booking("2023-02-02", jack, coding);
        bookingRepository.save(JackBooking);

        Booking jillBooking = new Booking("2023-02-02",
                jill, maths);
        bookingRepository.save(jillBooking);


    }

}
