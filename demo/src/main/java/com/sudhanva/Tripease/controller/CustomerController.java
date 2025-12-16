package com.sudhanva.demo.controller;

import com.sudhanva.demo.Enum.Gender;
import com.sudhanva.demo.dto.request.CustomerRequest;
import com.sudhanva.demo.dto.response.CustomerResponse;
import com.sudhanva.demo.model.Customer;
import com.sudhanva.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController
{
    @Autowired
    CustomerService customerService;
    @PostMapping("/add")
    public CustomerResponse addCustomer(@RequestBody CustomerRequest customerRequest)
    {
        return customerService.addCustomer(customerRequest);
    }

    @GetMapping("/get/customer-id/{id}")
    public CustomerResponse getCustomer(@PathVariable("id") Integer customerid)
    {
        return customerService.getCustomer(customerid);
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers()
    {
        return customerService.getAllCustomers();
    }

    @GetMapping("/get/gender/{gender}")
    public List<CustomerResponse> getByGender(@PathVariable("gender") Gender gender)
    {
        return customerService.getByGender(gender);
    }

    @GetMapping("/get")
    public List<CustomerResponse> getByGenderAndAge(@RequestParam("gender") Gender gender,
                                                    @RequestParam("age") int age)
    {
        return customerService.getByGenderAndAge(gender,age);
    }

    @GetMapping("/get-gender-age-greater-than")
    public List<CustomerResponse> getByGenderAndAgeGreaterThan(@RequestParam("gender") Gender gender,
                                                               @RequestParam("age") int age)
    {
        return customerService.getByGenderAndAgeGreaterThan(gender,age);
    }
}
