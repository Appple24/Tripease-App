package com.sudhanva.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Cab
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CabId;
    private String CabNumber;
    private String CabModel;
    private double perKmRate;
    private boolean isAvailable;
}
