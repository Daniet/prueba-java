package com.daniel.softmanager.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class SaleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    private Sale sale;
    @OneToOne
    private Product product;
    private Long price;
    private int Quantity;
    private Long total;
}
