package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Grocery;
import com.daniel.softmanager.service.dto.GroceryInDTO;
import org.springframework.stereotype.Component;

@Component
public class GroceryInToGrocery implements IMapper<GroceryInDTO, Grocery> {

    @Override
    public Grocery map(GroceryInDTO in) {
        Grocery grocery = new Grocery();
        grocery.setName(in.getName());
        return grocery;
    }
}
