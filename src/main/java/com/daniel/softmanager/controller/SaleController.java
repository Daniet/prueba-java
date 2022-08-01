package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Sale;
import com.daniel.softmanager.service.SaleService;
import com.daniel.softmanager.service.dto.SaleInDTO;
import com.daniel.softmanager.service.dto.SaleReportDTO;
import com.daniel.softmanager.service.dto.SalesStatusDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public Sale create(@RequestBody SaleInDTO saleInDTO) {
        return this.saleService.create(saleInDTO);
    }

    @GetMapping
    public List<Sale> findAll() {
        return this.saleService.findAll();
    }

    @GetMapping("/{id}")
    public Sale findById(@PathVariable("id") Long id) {
        return this.saleService.findById(id);
    }

    @GetMapping("/report")
    public SalesStatusDTO getSaleReport() {
        return this.saleService.getSaleReport();
    }
}
