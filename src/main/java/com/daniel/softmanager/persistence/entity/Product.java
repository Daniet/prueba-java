package com.daniel.softmanager.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long price;
    private int maxSale;
    @OneToOne
    private ProductType type;
    @OneToOne
    private Laboratory laboratory;
}
