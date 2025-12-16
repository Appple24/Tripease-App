package com.sudhanva.demo.service;

import com.sudhanva.demo.Enum.Gender;
import com.sudhanva.demo.dto.request.CustomerRequest;
import com.sudhanva.demo.dto.response.CustomerResponse;
import com.sudhanva.demo.exception.CustomerNotFoundException;
import com.sudhanva.demo.model.Customer;
import com.sudhanva.demo.repository.CustomerRepository;
import com.sudhanva.demo.transformers.CustomerTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public CustomerResponse addCustomer(CustomerRequest customerRequest) {
        //Request dto to entity
        Customer customer = CustomerTransformer.customerRequestToCustomer(customerRequest);
        //save the entity
        Customer customer1 = customerRepository.save(customer);

        // returning saved entity to responseDto
        return CustomerTransformer.customerToCustomerResponse(customer1) ;
    }

    public CustomerResponse getCustomer(Integer id) {
        Optional<Customer> optionalCustomer =customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) {
            throw new CustomerNotFoundException("Invalid customer Id");
        }
        Customer customer1=optionalCustomer.get();

        return CustomerTransformer.customerToCustomerResponse(customer1);
    }

    public List<CustomerResponse> getAllCustomers() {
        List <Customer> customers = customerRepository.findAll();
        if(customers.isEmpty()) {
            throw new CustomerNotFoundException("NO CUSTOMER FOUND");
        }
        List <CustomerResponse> customerList = new ArrayList<>();
        for(Customer customer : customers) {
            //tranforming cutomer to customerResponse and adding in to list
            customerList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerList;
    }

    public List<CustomerResponse> getByGender(Gender gender) {
        List <Customer> customers = customerRepository.findByGender(gender);
        if(customers.isEmpty()) {
            throw new CustomerNotFoundException("Customers Not Found with Gender : "+gender);
        }
        List <CustomerResponse> customerList = new ArrayList<>();
        for(Customer customer : customers) {
            customerList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerList;
    }


    public List<CustomerResponse> getByGenderAndAge(Gender gender, int age) {
        List <Customer> customers = customerRepository.findByGenderAndAge(gender,age);
        if(customers.isEmpty()) {
            throw new CustomerNotFoundException("Customers Not Found with Gender : "+gender+" and Age : "+age);
        }
        List <CustomerResponse> customerList = new ArrayList<>();
        for(Customer customer : customers) {
            customerList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerList;
    }

    public List<CustomerResponse> getByGenderAndAgeGreaterThan(Gender gender, int age) {
       List <Customer> customers = customerRepository.getAllByGenderAndAgeGreaterThan(gender,age);
        if(customers.isEmpty()) {
            throw new CustomerNotFoundException("Customers Not Found with Gender : "+gender+" and Age : "+age);
        }
        List <CustomerResponse> customerList = new ArrayList<>();
        for(Customer customer : customers) {
            customerList.add(CustomerTransformer.customerToCustomerResponse(customer));
        }
        return customerList;
    }
}
