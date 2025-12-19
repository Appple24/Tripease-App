package com.sudhanva.demo.controller;

import com.sudhanva.demo.dto.request.BookingRequest;
import com.sudhanva.demo.dto.response.BookingResponse;
import com.sudhanva.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping("/book-cab/customer/{cutomerId}")
    public BookingResponse bookCab(@RequestBody BookingRequest bookingRequest,
                                   @PathVariable("cutomerId") Integer customerId) {

            return bookingService.bookCab(bookingRequest,customerId);
    }
}
