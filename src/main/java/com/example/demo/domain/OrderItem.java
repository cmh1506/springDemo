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
    private Order order;
    @OneToOne(cascade = CascadeType.ALL)
    private Item item;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Order order, Item item, String name, Currency price, Integer quantity) {
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }

    public OrderItem(Long id, Order order, Item item, String name, Currency price, Integer quantity) {
        this.id = id;
        this.order = order;
        this.item = item;
        this.quantity = quantity;
    }
}
