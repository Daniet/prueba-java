package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Client;
import com.daniel.softmanager.persistence.entity.Sale;
import com.daniel.softmanager.persistence.repository.ClientRepository;
import com.daniel.softmanager.service.SaleProductService;
import com.daniel.softmanager.service.dto.SaleInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SaleInToSale implements IMapper<SaleInDTO, Sale> {

    @Autowired
    private ClientRepository clientRepository;
    private SaleProductService saleProductService;

    @Override
    public Sale map(SaleInDTO in) {
        Sale sale = new Sale();
        Client client = clientRepository.findByDni(in.getDni());
        sale.setClient(client);
        sale.setCreateAt(LocalDateTime.now());
        return sale;
    }
}
