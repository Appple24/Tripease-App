package com.sudhanva.demo.model;

import com.sudhanva.demo.Enum.TripStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
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

    @CreationTimestamp
    Date bookedAt;

    @UpdateTimestamp
    Date lastUpdateAt;
}
