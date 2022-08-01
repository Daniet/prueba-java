package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.LaboratoryInToLaboratory;
import com.daniel.softmanager.persistence.entity.Laboratory;
import com.daniel.softmanager.persistence.repository.LaboratoryRepository;
import com.daniel.softmanager.service.dto.LaboratoryInDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaboratoryService {

    private final LaboratoryRepository repository;
    private final LaboratoryInToLaboratory mapper;

    public LaboratoryService(LaboratoryRepository repository, LaboratoryInToLaboratory mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Laboratory create(LaboratoryInDTO laboratoryInDTO) {
        Laboratory laboratory = mapper.map(laboratoryInDTO);
        this.repository.save(laboratory);
        return laboratory;
    }

    public List<Laboratory> findAll() {
        return this.repository.findAll();
    }
}
