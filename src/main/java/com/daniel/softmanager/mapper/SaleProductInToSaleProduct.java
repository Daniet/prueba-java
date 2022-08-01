package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Product;
import com.daniel.softmanager.persistence.entity.Sale;
import com.daniel.softmanager.persistence.entity.SaleProduct;
import com.daniel.softmanager.persistence.repository.ProductRepository;
import com.daniel.softmanager.persistence.repository.SaleRepository;
import com.daniel.softmanager.service.dto.SaleProductInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleProductInToSaleProduct implements IMapper<SaleProductInDTO, SaleProduct> {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public SaleProduct map(SaleProductInDTO in) {
        SaleProduct saleProduct = new SaleProduct();
        Product product = productRepository.findById(in.getProduct()).get();
        Sale sale = saleRepository.findById(in.getSale()).get();

        saleProduct.setProduct(product);
        saleProduct.setPrice(product.getPrice());
        saleProduct.setQuantity(in.getQuantity());
        saleProduct.setSale(sale);
        saleProduct.setTotal(product.getPrice() * in.getQuantity());
        return saleProduct;
    }
}
