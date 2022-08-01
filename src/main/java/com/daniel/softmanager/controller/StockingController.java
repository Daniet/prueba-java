package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Stocktaking;
import com.daniel.softmanager.service.StocktakingService;
import com.daniel.softmanager.service.dto.StockingInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocking")
public class StockingController {

    private final StocktakingService stocktakingService;

    public StockingController(StocktakingService stocktakingService) {
        this.stocktakingService = stocktakingService;
    }

    @PostMapping
    public Stocktaking create(@RequestBody StockingInDTO stockingInDTO) {
        return this.stocktakingService.create(stockingInDTO);
    }

    @GetMapping
    public List<Stocktaking> findAll() {
        return this.stocktakingService.findAll();
    }
}
