package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.ProductType;
import com.daniel.softmanager.service.dto.ProductTypeInDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeToProduct implements IMapper<ProductTypeInDTO, ProductType> {

    @Override
    public ProductType map(ProductTypeInDTO in) {
        ProductType productType = new ProductType();
        productType.setName(in.getName());
        return productType;
    }
}
