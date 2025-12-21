package com.sudhanva.demo.dto.request;

import com.sudhanva.demo.Enum.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CustomerRequest
{
    private Integer customerID;
    private String custName;
    private String email;
    private Integer age;
    private Gender gender;
}
