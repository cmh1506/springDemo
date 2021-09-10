package com.example.demo.dto;

import com.example.demo.dto.OrderItem;

import java.math.BigDecimal;
import java.util.List;

public class OrderDTO {
    Long id;
    Long customerId;
    String pMethod;
    BigDecimal gTotal;
    private List<OrderItem> orderItems;

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public OrderDTO() {
    }

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
}
