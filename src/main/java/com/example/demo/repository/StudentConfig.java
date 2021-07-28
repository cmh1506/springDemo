package com.example.demo.repository;

import com.example.demo.domain.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            repository.saveAll(List.of(
                    new Student("Maria Cabrero", "maria@cabrero.com"),
                    new Student("Claus Heinrich", "maria@cabrero.com")
            ));
        };
    }
}
