package com.sudhanva.demo.service;

import com.sudhanva.demo.dto.request.BookingRequest;
import com.sudhanva.demo.dto.response.BookingResponse;
import com.sudhanva.demo.exception.CabUnavaliableException;
import com.sudhanva.demo.exception.CustomerNotFoundException;
import com.sudhanva.demo.model.Booking;
import com.sudhanva.demo.model.Cab;
import com.sudhanva.demo.model.Customer;
import com.sudhanva.demo.model.Driver;
import com.sudhanva.demo.repository.BookingRepository;
import com.sudhanva.demo.repository.CabRepository;
import com.sudhanva.demo.repository.CustomerRepository;
import com.sudhanva.demo.repository.DriverRepository;
import com.sudhanva.demo.transformers.BookingTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CabRepository cabRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    DriverRepository driverRepository;

    public BookingResponse bookCab(BookingRequest bookingRequest, Integer customerId) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if(optionalCustomer.isEmpty()){
            throw new CustomerNotFoundException("Customer not found");
        }
        Customer customer = optionalCustomer.get();
        Cab avaliableCab = cabRepository.getAvaliableCabRandomly();
        if(avaliableCab==null){
            throw new CabUnavaliableException("Sorry no cab avaliable.....");
        }

        Booking booking = BookingTransformer.BookingRequestToBooking(bookingRequest, avaliableCab.getPerKmRate());
        Booking savedBooking =bookingRepository.save(booking);
        avaliableCab.setAvailable(false);
        customer.getBookings().add(savedBooking);

        Driver driver = driverRepository.getDriverByCabId(avaliableCab.getCabId());
        driver.getBookings().add(savedBooking);

        Customer savedCustomer=customerRepository.save(customer);
        Driver savedDriver=driverRepository.save(driver);
        return BookingTransformer.BookingToBookingResponse(savedBooking,savedCustomer,avaliableCab,driver);
    }
}
