package com.daniel.softmanager.persistence.repository;

import com.daniel.softmanager.persistence.entity.Grocery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {
}
