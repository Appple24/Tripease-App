package com.sudhanva.demo.transformers;

import com.sudhanva.demo.Enum.TripStatus;
import com.sudhanva.demo.dto.request.BookingRequest;
import com.sudhanva.demo.dto.response.BookingResponse;
import com.sudhanva.demo.model.Booking;
import com.sudhanva.demo.model.Cab;
import com.sudhanva.demo.model.Customer;
import com.sudhanva.demo.model.Driver;

public class BookingTransformer {

    public static BookingResponse BookingToBookingResponse(Booking booking, Customer customer, Cab cab, Driver driver) {
        return BookingResponse.builder().
                pickUp(booking.getPickUp()).
                destination(booking.getDestination()).
                tripDistanceInKm(booking.getTripDistanceInKm()).
                tripStatus(booking.getTripStatus()).
                billAmount(booking.getBillAmount()).
                bookedAt(booking.getBookedAt()).
                lastUpdateAt(booking.getLastUpdateAt()).
                customer(CustomerTransformer.customerToCustomerResponse(customer)).
                cab(CabTransformer.cabToCabResponse(cab,driver)).
                build();
    }

    public static Booking BookingRequestToBooking(BookingRequest bookingRequest,double perKmRate) {
        return Booking.builder().
                pickUp(bookingRequest.getPickup()).
                destination(bookingRequest.getDestination()).
                tripDistanceInKm(bookingRequest.getTripDistanceInKm()).
                tripStatus(TripStatus.InProgress).
                billAmount(bookingRequest.getTripDistanceInKm()*perKmRate).
                build();
    }
}
