package com.example.demo.controller;

import com.example.demo.domain.Order;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderLineItem;
import com.example.demo.service.OrderItemService;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
    public final OrderService orderService;
    public final OrderItemService orderItemService;
    @Autowired
    public OrderController(OrderService orderService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }
    @GetMapping("/orders")
    public List<OrderLineItem> getOrders(){
        return orderService.getOrders();
    }

    @PostMapping(path = "/addOrder")
    public Boolean addOrder(@RequestBody OrderDTO orderDTO){
        orderService.addNewOrder(orderDTO);
        return true;
    }

}
