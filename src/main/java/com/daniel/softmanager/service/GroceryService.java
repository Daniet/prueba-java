package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.GroceryInToGrocery;
import com.daniel.softmanager.persistence.entity.Grocery;
import com.daniel.softmanager.persistence.repository.GroceryRepository;
import com.daniel.softmanager.service.dto.GroceryInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryService {

    private final GroceryRepository repository;
    private final GroceryInToGrocery mapper;

    public GroceryService(GroceryRepository repository, GroceryInToGrocery mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Grocery create(GroceryInDTO groceryInDTO) {
        Grocery grocery = mapper.map(groceryInDTO);
        this.repository.save(grocery);
        return grocery;
    }

    public List<Grocery> findAll() {
        return this.repository.findAll();
    }
}
