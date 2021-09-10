package com.example.demo.service;

import com.example.demo.domain.OrderItem;
import com.example.demo.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService {
    public final OrderItemRepository orderItemRepository;
    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }
    public List<OrderItem> getOrderItems() {
        return orderItemRepository.findAll();
    }

    public void addNewOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public Optional<OrderItem> findById(Long id) {
        return orderItemRepository.findById(id);
    }
}
