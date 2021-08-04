package com.example.demo.repository;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Hero;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner initCustomers(CustomerRepository repository){
        return args -> {
            Stream.of("Olivia Kathleen", "Liam Patrick", "Charlotte Rose", "Elijah Burke", "Ayesha Ameer", "Eva Louis").forEach(name -> {
                Customer customer = new Customer(name);
                repository.save(customer);
            });
            repository.findAll();

        };
    }
}
