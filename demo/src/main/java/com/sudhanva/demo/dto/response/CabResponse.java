package com.sudhanva.demo.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CabResponse {

    private String CabNumber;

    private String CabModel;

    private double perKmRate;

    private boolean available;

    private DriverResponse driver;

}
