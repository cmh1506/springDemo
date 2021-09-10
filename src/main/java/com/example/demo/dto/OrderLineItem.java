package com.example.demo.dto;

import com.example.demo.domain.Order;

import java.math.BigDecimal;

public class OrderLineItem {
    Long id;
    Long customerId;
    String customer;
    String pMethod;
    BigDecimal gTotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
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

    public OrderLineItem() {
    }

    public OrderLineItem(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomer().getId();
        this.customer = order.getCustomer().getName();
        this.pMethod = order.getpMethod();
        this.gTotal = order.getgTotal();
    }

    public OrderLineItem(Long id, String customer, String pMethode, BigDecimal gTotal) {
        this.id = id;
        this.customer = customer;
        this.pMethod = pMethode;
        this.gTotal = gTotal;
    }
}
