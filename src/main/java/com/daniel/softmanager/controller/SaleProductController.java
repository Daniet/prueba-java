package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.SaleProduct;
import com.daniel.softmanager.service.SaleProductService;
import com.daniel.softmanager.service.dto.SaleProductInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale_product")
public class SaleProductController {

    private final SaleProductService saleProductService;

    public SaleProductController(SaleProductService saleProductService) {
        this.saleProductService = saleProductService;
    }

    @PostMapping
    public SaleProduct create(@RequestBody SaleProductInDTO saleProductInDTO) {
        return this.saleProductService.create(saleProductInDTO);
    }

    @GetMapping
    public List<SaleProduct> findAll() {
        return this.saleProductService.findAll();
    }
}
