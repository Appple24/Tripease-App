package com.sudhanva.demo.transformers;

import com.sudhanva.demo.dto.request.CustomerRequest;
import com.sudhanva.demo.dto.response.CustomerResponse;
import com.sudhanva.demo.model.Customer;

public class CustomerTransformer {

    public static Customer customerRequestToCustomer(CustomerRequest customerRequest){

        //traditional...............................
//        Customer customer =new Customer();
//        customer.setAge(customerRequest.getAge());
//        customer.setGender(customerRequest.getGender());
//        customer.setEmail(customerRequest.getEmail());
//        customer.setCustName(customerRequest.getCustName());

        //using builder....................
        Customer customer = Customer.builder()
                .custName(customerRequest.getCustName())
                .age(customerRequest.getAge())
                .gender(customerRequest.getGender())
                .email(customerRequest.getEmail())
                .build();

        return customer;
    }

    public static CustomerResponse customerToCustomerResponse(Customer customer){
        //traditional...............................
//        CustomerResponse customerReponse = new CustomerResponse();
//        customerReponse.setAge(customer.getAge());
//        customerReponse.setEmail(customer.getEmail());
//        customerReponse.setCustName(customer.getCustName());

        //using builder....................
        CustomerResponse customerResponse=CustomerResponse.builder()
                .age(customer.getAge())
                .email(customer.getEmail())
                .custName(customer.getCustName())
                .build();
        return customerResponse;
    }
}
