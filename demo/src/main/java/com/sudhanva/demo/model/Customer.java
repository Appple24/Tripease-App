package com.sudhanva.demo.model;

import com.sudhanva.demo.Enum.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerID;
    private String custName;

    @Column(unique = true,nullable = false)
    private String email;
    private Integer age;

    @Enumerated(value=EnumType.STRING)
    private Gender gender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id")
    List<Booking> bookings=new ArrayList<>();
}

