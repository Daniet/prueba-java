package com.daniel.softmanager.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Stocktaking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime in;
    private LocalDateTime out;
    @OneToOne
    private Grocery grocery;
    @OneToOne
    private Product product;
}
