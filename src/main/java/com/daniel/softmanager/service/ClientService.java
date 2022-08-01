package com.daniel.softmanager.service;

import com.daniel.softmanager.mapper.ClientInToClient;
import com.daniel.softmanager.persistence.entity.Client;
import com.daniel.softmanager.persistence.repository.ClientRepository;
import com.daniel.softmanager.service.dto.ClientInDTO;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    private final ClientRepository repository;
    private final ClientInToClient mapper;

    public ClientService(ClientRepository repository, ClientInToClient mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Client create(ClientInDTO clientInDTO) {
        Client client = mapper.map(clientInDTO);
        this.repository.save(client);
        return client;
    }

    public Client findByDni(String dni) {
        return this.repository.findByDni(dni);
    }
}
