package com.sudhanva.demo.model;

import com.sudhanva.demo.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private String pickUp;
    private String destination;
    private double tripDistanceInKm;
    @Enumerated(value=EnumType.STRING)
    private TripStatus tripStatus;
    private double billAmount;
}
