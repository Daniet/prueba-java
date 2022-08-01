package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Laboratory;
import com.daniel.softmanager.persistence.entity.Product;
import com.daniel.softmanager.persistence.entity.ProductType;
import com.daniel.softmanager.persistence.repository.LaboratoryRepository;
import com.daniel.softmanager.persistence.repository.ProductTypeRepository;
import com.daniel.softmanager.service.dto.ProductInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductInToProduct implements IMapper<ProductInDTO, Product> {

    @Autowired
    private ProductTypeRepository productTypeRepository;
    @Autowired
    private LaboratoryRepository laboratoryRepository;

    @Override
    public Product map(ProductInDTO in) {
        Product product = new Product();

        ProductType productType = this.productTypeRepository.findById(in.getProductType()).get();
        Laboratory laboratory = this.laboratoryRepository.findById(in.getLaboratory()).get();

        product.setName(in.getName());
        product.setPrice(in.getPrice());
        product.setMaxSale(in.getMaxSale());
        product.setType(productType);
        product.setLaboratory(laboratory);
        return product;
    }
}
