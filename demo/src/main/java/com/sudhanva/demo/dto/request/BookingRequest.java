package com.sudhanva.demo.dto.request;

import com.sudhanva.demo.Enum.TripStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookingRequest {
    private String pickup;
    private String destination;
    double tripDistanceInKm;
}
