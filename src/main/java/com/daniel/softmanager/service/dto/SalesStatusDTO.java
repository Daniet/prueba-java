package com.daniel.softmanager.service.dto;

import lombok.Data;

import java.util.List;

@Data
public class SalesStatusDTO {
    private String bestSellingProduct;
    private String leastSoldProduct;
    private List<SaleReportDTO> saleReport;
}
