package com.example.demo.service;

import com.example.demo.domain.Order;
import com.example.demo.domain.OrderItem;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.OrderLineItem;
import com.example.demo.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerService customerService;
    private final ItemService itemService;
    private final OrderItemService orderItemService;
    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerService customerService, ItemService itemService, OrderItemService orderItemService) {
        this.orderRepository = orderRepository;
        this.customerService = customerService;
        this.itemService = itemService;
        this.orderItemService = orderItemService;
    }
    public List<OrderLineItem> getOrders() {
        return orderRepository.findAll().stream().map(OrderLineItem::new)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Order addNewOrder(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order addNewOrder(OrderDTO orderDTO){
        Order order = dtoToOrder(orderDTO);
        orderRepository.save(order);
        return orderRepository.save(order);
    }

    private Order dtoToOrder(OrderDTO orderDTO) {
        Order order = null;
        if (orderDTO.getId() == 0){
            order = new Order();
        } else {
            order = orderRepository.findById(orderDTO.getId()).orElseThrow();
        }
        order.setCustomer(customerService.findById(orderDTO.getCustomerId()).orElseThrow());
        order.setgTotal(orderDTO.getgTotal());
        order.setpMethod(orderDTO.getpMethod());
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (com.example.demo.dto.OrderItem orderItemDTO: orderDTO.getOrderItems()) {
            OrderItem orderItem = null;
            if(orderItemDTO.getId() == 0){
                orderItem = new OrderItem();
            } else {
                orderItem = orderItemService.findById(orderItemDTO.getId()).orElseThrow();
            }
            orderItem.setOrder(order);
            orderItem.setItem(itemService.findById(orderItemDTO.getItemId()).orElseThrow());
            orderItem.setQuantity(orderItemDTO.getQuantity());
            orderItems.add(orderItem);
        }
        order.setOrderItems(orderItems);
        return order;
    }
}
