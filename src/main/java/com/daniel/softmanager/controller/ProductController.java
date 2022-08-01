package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Product;
import com.daniel.softmanager.service.ProductService;
import com.daniel.softmanager.service.dto.ProductInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody ProductInDTO productInDTO) {
        return this.productService.create(productInDTO);
    }

    @GetMapping
    public List<Product> findAll() {
        return this.productService.findAll();
    }
}
