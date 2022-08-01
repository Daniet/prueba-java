package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.ProductTypeToProduct;
import com.daniel.softmanager.persistence.entity.ProductType;
import com.daniel.softmanager.persistence.repository.ProductTypeRepository;
import com.daniel.softmanager.service.dto.ProductTypeInDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeService {

    private final ProductTypeRepository repository;
    private final ProductTypeToProduct mapper;

    public ProductTypeService(ProductTypeRepository repository, ProductTypeToProduct mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductType create(ProductTypeInDTO productTypeInDTO) {
        ProductType productType = mapper.map(productTypeInDTO);
        this.repository.save(productType);
        return productType;
    }

    public ProductType getById(Long id) {
        return this.repository.getById(id);
    }

    public List<ProductType> findAll() {
        return this.repository.findAll();
    }

    public ProductType findById(Long id) {
        return this.repository.findById(id).get();
    }
}
