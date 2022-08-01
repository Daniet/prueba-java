package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Grocery;
import com.daniel.softmanager.service.GroceryService;
import com.daniel.softmanager.service.dto.GroceryInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    private final GroceryService groceryService;

    public GroceryController(GroceryService groceryService) {
        this.groceryService = groceryService;
    }

    @PostMapping
    public Grocery create(@RequestBody GroceryInDTO groceryInDTO) {
        return this.groceryService.create(groceryInDTO);
    }

    @GetMapping
    public List<Grocery> findAll() {
        return this.groceryService.findAll();
    }
}
