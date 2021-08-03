package com.example.demo.domain;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "order_item", schema = "orderapp")
public class Order_item {
    @Id
    @SequenceGenerator(
            name = "order_item_sequence",
            sequenceName = "order_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_item_sequence"
    )
    private Long id;
    private String name;
    private Currency price;
}
