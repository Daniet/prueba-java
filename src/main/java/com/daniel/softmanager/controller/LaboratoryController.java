package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Laboratory;
import com.daniel.softmanager.service.LaboratoryService;
import com.daniel.softmanager.service.dto.LaboratoryInDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laboratory")
public class LaboratoryController {

    private final LaboratoryService laboratoryService;

    public LaboratoryController(LaboratoryService laboratoryService) {
        this.laboratoryService = laboratoryService;
    }

    @PostMapping
    public Laboratory create(@RequestBody LaboratoryInDTO laboratoryInDTO) {
        return this.laboratoryService.create(laboratoryInDTO);
    }

    @GetMapping
    public List<Laboratory> findAll() {
        return this.laboratoryService.findAll();
    }
}
