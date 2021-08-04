package com.example.demo.repository;

import com.example.demo.domain.Item;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.stream.Stream;

@Configuration
public class ItemConfig {
    @Bean
    CommandLineRunner initItems(ItemRepository repository) {
        return args -> {
            Item i1 = new Item("Carbonara", BigDecimal.valueOf(10.9) );
            repository.save(i1);
            Item i2 = new Item("Lasagne", BigDecimal.valueOf(11.9) );
            repository.save(i2);
            Item i3 = new Item("Pizza Salami", BigDecimal.valueOf(12.9) );
            repository.save(i3);
            Item i4 = new Item("Insalada Mista", BigDecimal.valueOf(13.9) );
            repository.save(i4);
            Item i5 = new Item("Tagliatelle", BigDecimal.valueOf(14.9) );
            repository.save(i5);

        };

    }
}
