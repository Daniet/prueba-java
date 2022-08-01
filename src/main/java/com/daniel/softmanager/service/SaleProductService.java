package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.SaleProductInToSaleProduct;
import com.daniel.softmanager.persistence.entity.Product;
import com.daniel.softmanager.persistence.entity.SaleProduct;
import com.daniel.softmanager.persistence.repository.ProductRepository;
import com.daniel.softmanager.persistence.repository.SaleProductRepository;
import com.daniel.softmanager.persistence.repository.StocktakingRepository;
import com.daniel.softmanager.service.dto.SaleProductInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SaleProductService {

    @Autowired
    private final SaleProductRepository repository;
    @Autowired
    private final StocktakingRepository stocktakingRepository;
    private final SaleProductInToSaleProduct mapper;
    @Autowired
    private final ProductRepository productRepository;

    public SaleProductService(SaleProductRepository repository, StocktakingRepository stocktakingRepository,
                              SaleProductInToSaleProduct mapper, ProductRepository productRepository) {
        this.repository = repository;
        this.stocktakingRepository = stocktakingRepository;
        this.mapper = mapper;
        this.productRepository = productRepository;
    }

    public boolean validateCreateSale(Product product, SaleProductInDTO saleProductInDTO) {
        if (this.stocktakingRepository.quantityAvailable(product.getId()) > saleProductInDTO.getQuantity()) {
            System.out.println(product.getMaxSale() + " <= " + saleProductInDTO.getQuantity());
            if (product.getMaxSale() >= saleProductInDTO.getQuantity()) {
                return true;
            }
            if (product.getMaxSale() == 0) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    public SaleProduct create(SaleProductInDTO saleProductInDTO) {
        Product product = this.productRepository.findById(saleProductInDTO.getProduct()).get();
        System.out.println(product.getName());
        if (this.validateCreateSale(product, saleProductInDTO)) {
            SaleProduct saleProduct = mapper.map(saleProductInDTO);
            this.repository.save(saleProduct);
            this.stocktakingRepository.changeAvailable(product.getId(), saleProductInDTO.getQuantity());
            return saleProduct;
        } else return null;
    }

    public List<SaleProduct> findAll() {
        return this.repository.findAll();
    }
}
