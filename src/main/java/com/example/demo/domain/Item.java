package com.example.demo.domain;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "item", schema = "orderapp")
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    private String name;
    private Currency price;

    public Item() {
    }

    public Item(String name, Currency price) {
        this.name = name;
        this.price = price;
    }

    public Item(Long id, String name, Currency price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
