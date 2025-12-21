package com.sudhanva.demo.repository;

import com.sudhanva.demo.model.Booking;
import com.sudhanva.demo.model.Cab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Integer> {

}
