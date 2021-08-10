package com.example.demo.domain;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "order", schema = "orderapp")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Customer customer;
    private String orderNumber;
    private Currency price;

    public Order() {
    }

    public Order(Customer customer, String orderNumber, Currency price) {
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.price = price;
    }

    public Order(Long id, Customer customer, String orderNumber, Currency price) {
        this.id = id;
        this.customer = customer;
        this.orderNumber = orderNumber;
        this.price = price;
    }
}
