package com.daniel.softmanager.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Grocery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
}
