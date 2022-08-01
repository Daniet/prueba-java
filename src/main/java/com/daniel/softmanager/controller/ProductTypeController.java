package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.ProductType;
import com.daniel.softmanager.service.ProductTypeService;
import com.daniel.softmanager.service.dto.ProductTypeInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product_type")
public class ProductTypeController {

    private final ProductTypeService productTypeService;

    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @PostMapping
    public ProductType create(@RequestBody ProductTypeInDTO productTypeInDTO) {
        return this.productTypeService.create(productTypeInDTO);
    }

    @GetMapping
    public List<ProductType> findAll() {
        return this.productTypeService.findAll();
    }
}
