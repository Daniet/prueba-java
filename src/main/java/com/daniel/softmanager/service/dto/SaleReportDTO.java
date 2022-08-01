package com.daniel.softmanager.service.dto;

import lombok.Data;
@Data
public class SaleReportDTO {
    private Long id;
    private String product;
    private Long sale;
    private Long total;
}
