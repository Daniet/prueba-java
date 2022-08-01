package com.daniel.softmanager.service.dto;

import lombok.Data;

@Data
public class ProductInDTO {
    private String name;
    private Long price;
    private Long productType;
    private Long laboratory;
    private int maxSale;
}
