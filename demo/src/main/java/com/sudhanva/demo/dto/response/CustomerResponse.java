package com.sudhanva.demo.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerResponse
{
    private String custName;
    private String email;
    private Integer age;
}
