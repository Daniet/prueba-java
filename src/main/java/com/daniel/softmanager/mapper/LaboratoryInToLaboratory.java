package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Laboratory;
import com.daniel.softmanager.service.dto.LaboratoryInDTO;
import org.springframework.stereotype.Component;

@Component
public class LaboratoryInToLaboratory implements IMapper<LaboratoryInDTO, Laboratory> {

    @Override
    public Laboratory map(LaboratoryInDTO in) {
        Laboratory laboratory = new Laboratory();
        laboratory.setName(in.getName());
        return laboratory;
    }
}
