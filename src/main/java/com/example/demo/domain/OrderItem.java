package com.example.demo.domain;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "order_item", schema = "orderapp")
public class OrderItem {
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;
    private String name;
    private Currency price;

    public OrderItem() {
    }

    public OrderItem(Order order, String name, Currency price) {
        this.order = order;
        this.name = name;
        this.price = price;
    }

    public OrderItem(Long id, Order order, String name, Currency price) {
        this.id = id;
        this.order = order;
        this.name = name;
        this.price = price;
    }
}
