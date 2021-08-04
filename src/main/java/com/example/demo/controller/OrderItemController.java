package com.example.demo.controller;

import com.example.demo.domain.Customer;
import com.example.demo.domain.OrderItem;
import com.example.demo.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderItemController {
    private final OrderItemService orderItemService;
    @Autowired
    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }
    @GetMapping("/orderItems")
    public List<OrderItem> getOrderItems() {
        return orderItemService.getOrderItems();
    }
}
