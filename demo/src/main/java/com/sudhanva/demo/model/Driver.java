package com.sudhanva.demo.model;

import jakarta.persistence.*;
import lombok.*;
import com.sudhanva.demo.model.Cab;
import com.sudhanva.demo.model.Booking;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Driver
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer driverID;
    private String driverName;

    @Column(unique = true,nullable = false)
    private String email;
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="driver_id")
    List<Booking> bookings =new ArrayList<>() ;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="cab_id")
    Cab cab;
}
