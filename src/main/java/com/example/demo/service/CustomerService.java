package com.example.demo.service;

import com.example.demo.domain.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    @Autowired
    public CustomerService (CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findById(Long customerId) {
        return customerRepository.findById(customerId);
    }
}
