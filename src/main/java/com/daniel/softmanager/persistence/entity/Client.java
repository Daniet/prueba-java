package com.daniel.softmanager.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String dni;
    private String name;
}
