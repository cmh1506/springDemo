package com.example.demo.repository;

import com.example.demo.domain.Student;
import com.example.demo.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository, UserRepository userRepository) {
        return args -> {
            repository.saveAll(List.of(
                    new Student("Maria Cabrero", "maria@cabrero.com", new User("Maria Cabrero", "maria@cabrero.com")),
                    new Student("Claus Heinrich", "maria@cabrero.com", new User("Claus Heinrich", "claus.heinrich@bol-systemhaus.de"))
            ));
        };
    }
}
