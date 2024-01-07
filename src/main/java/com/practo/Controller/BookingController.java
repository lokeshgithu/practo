package com.practo.Controller;

import com.practo.Entity.Booking;
import com.practo.Payload.BookingDto;
import com.practo.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public ResponseEntity<String> bookAnAppointment(@RequestBody BookingDto bookingDto){

        bookingService.bookAnAppointment(bookingDto);
        return new ResponseEntity<>("Booking is confirmed", HttpStatus.CREATED);

    }
}