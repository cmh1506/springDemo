package com.example.demo.controller;

import com.example.demo.domain.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
    private final ItemService service;
    @Autowired
    public ItemController(ItemService service) {
        this.service = service;
    }

    @GetMapping("/items")
    public List<Item> getItems() {
        return service.getItems();
    }
}
