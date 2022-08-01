package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.ProductInToProduct;
import com.daniel.softmanager.persistence.entity.Product;
import com.daniel.softmanager.persistence.repository.ProductRepository;
import com.daniel.softmanager.service.dto.ProductInDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductInToProduct mapper;

    public ProductService(ProductRepository repository, ProductInToProduct mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Product create(ProductInDTO productInDTO) {
        Product product = mapper.map(productInDTO);
        this.repository.save(product);
        return product;
    }

    public List<Product> findAll() {
        return this.repository.findAll();
    }

//    public Optional<Product> findById(Long id) {
//        return this.repository.findById(id).;
//    }
}
