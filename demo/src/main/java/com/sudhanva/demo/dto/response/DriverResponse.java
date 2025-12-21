package com.sudhanva.demo.dto.response;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class DriverResponse {

    private Integer driverID;
    private String driverName;
    private String email;
    private Integer age;
}
