package com.daniel.softmanager.persistence.repository;

import com.daniel.softmanager.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    public Client findByDni(String dni);
}
