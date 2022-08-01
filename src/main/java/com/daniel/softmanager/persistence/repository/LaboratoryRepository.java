package com.daniel.softmanager.persistence.repository;

import com.daniel.softmanager.persistence.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {
}
