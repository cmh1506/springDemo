package com.example.demo.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Set;

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
    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;
    private Currency price;
    private String pMethod;
    private BigDecimal gTotal;
    @OneToMany(cascade = CascadeType.ALL,
            mappedBy = "order", orphanRemoval = true)
    private List<OrderItem> orderItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Currency getPrice() {
        return price;
    }

    public void setPrice(Currency price) {
        this.price = price;
    }

    public String getpMethod() {
        return pMethod;
    }

    public void setpMethod(String pMethod) {
        this.pMethod = pMethod;
    }

    public BigDecimal getgTotal() {
        return gTotal;
    }

    public void setgTotal(BigDecimal gTotal) {
        this.gTotal = gTotal;
    }

    public Order() {

    }

    public Order(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Order(Customer customer, Currency price, List<OrderItem> orderItems) {
        this.customer = customer;
        this.price = price;
        this.orderItems = orderItems;
    }

    public Order(Long id, Customer customer, Currency price, List<OrderItem> orderItems) {
        this.id = id;
        this.customer = customer;
        this.price = price;
        this.orderItems = orderItems;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
