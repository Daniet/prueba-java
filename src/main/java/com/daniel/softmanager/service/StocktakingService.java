package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.StockingInToStocking;
import com.daniel.softmanager.persistence.entity.Stocktaking;
import com.daniel.softmanager.persistence.repository.StocktakingRepository;
import com.daniel.softmanager.service.dto.StockingInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StocktakingService {

    private final StocktakingRepository repository;
    private final StockingInToStocking mapper;

    public StocktakingService(StocktakingRepository repository, StockingInToStocking mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Stocktaking create(StockingInDTO stockingInDTO) {
        Stocktaking stocktaking = mapper.map(stockingInDTO);
        this.repository.save(stocktaking);
        return  stocktaking;
    }

    public List<Stocktaking> findAll() {
        return this.repository.findAll();
    }
}
