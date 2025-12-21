package com.sudhanva.demo.dto.response;

import com.sudhanva.demo.Enum.TripStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class BookingResponse {

    private String pickUp;

    private String destination;

    private double tripDistanceInKm;

    private TripStatus tripStatus;

    private double billAmount;

    Date bookedAt;

    Date lastUpdateAt;

    CustomerResponse customer;

    CabResponse cab;
}
