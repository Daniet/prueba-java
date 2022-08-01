package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Grocery;
import com.daniel.softmanager.persistence.entity.Product;
import com.daniel.softmanager.persistence.entity.Stocktaking;
import com.daniel.softmanager.persistence.repository.GroceryRepository;
import com.daniel.softmanager.persistence.repository.ProductRepository;
import com.daniel.softmanager.service.dto.StockingInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class StockingInToStocking implements IMapper<StockingInDTO, Stocktaking>{

    @Autowired
    private GroceryRepository groceryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Stocktaking map(StockingInDTO in) {
        Stocktaking stocktaking = new Stocktaking();

        Grocery grocery = this.groceryRepository.findById(in.getGrocery()).get();
        Product product = this.productRepository.findById(in.getProduct()).get();

        stocktaking.setIn(LocalDateTime.now());
        stocktaking.setGrocery(grocery);
        stocktaking.setProduct(product);
        return stocktaking;
    }
}
