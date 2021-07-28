package com.example.demo.repository;

import com.example.demo.domain.Hero;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class HeroConfig {
    @Bean
    CommandLineRunner initHeros(HeroRepository repository) {
        return args -> {
            Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
                Hero hero = new Hero(name);
                repository.save(hero);
            });
            repository.findAll();
        };
    }
}
