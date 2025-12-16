package com.sudhanva.demo.dto.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DriverRequest {

    private Integer age;
    private String driverName;
    private String email;
}
