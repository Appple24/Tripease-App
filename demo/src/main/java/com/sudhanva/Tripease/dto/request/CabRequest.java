package com.sudhanva.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CabRequest {

    private String CabNumber;

    private String CabModel;

    private double perKmRate;
}
