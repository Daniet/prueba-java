package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.ObjectToSaleReport;
import com.daniel.softmanager.mapper.SaleInToSale;
import com.daniel.softmanager.mapper.SaleProductInToSaleProduct;
import com.daniel.softmanager.persistence.entity.Sale;
import com.daniel.softmanager.persistence.repository.SaleRepository;
import com.daniel.softmanager.service.dto.SaleInDTO;
import com.daniel.softmanager.service.dto.SaleReportDTO;
import com.daniel.softmanager.service.dto.SalesStatusDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {
    @Autowired
    private final SaleRepository repository;
    private final SaleInToSale mapper;
    public final ObjectToSaleReport saleReportMapper;

    public SaleService(SaleRepository repository, SaleInToSale mapper, SaleProductInToSaleProduct saleProductMapper,
                       ObjectToSaleReport saleReportMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.saleReportMapper = saleReportMapper;
    }

    public Sale create(SaleInDTO saleInDTO) {
        Sale sale = mapper.map(saleInDTO);
        this.repository.save(sale);
        return sale;
    }

    public List<Sale> findAll() {
        return this.repository.findAll();
    }

    public Sale findById(Long id) {
        return this.repository.findById(id).get();
    }

    @PersistenceContext
    private EntityManager em;

    public SalesStatusDTO getSaleReport() {
        List<SaleReportDTO> saleReportDTOS = new ArrayList<>();
        SalesStatusDTO salesStatus = new SalesStatusDTO();
        for (Object[] x: this.repository.getSaleReport()) saleReportDTOS.add(this.saleReportMapper.map(x));
        salesStatus.setSaleReport(saleReportDTOS);
        salesStatus.setBestSellingProduct(saleReportDTOS.get(0).getProduct());
        salesStatus.setLeastSoldProduct(saleReportDTOS.get(saleReportDTOS.size() - 1).getProduct());
        return salesStatus;
    }
}
