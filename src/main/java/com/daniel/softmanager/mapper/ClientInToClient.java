package com.daniel.softmanager.mapper;

import com.daniel.softmanager.persistence.entity.Client;
import com.daniel.softmanager.service.dto.ClientInDTO;
import org.springframework.stereotype.Component;

@Component
public class ClientInToClient implements IMapper<ClientInDTO, Client> {

    @Override
    public Client map(ClientInDTO in) {
        Client client = new Client();
        client.setDni(in.getDni());
        client.setName(in.getName());
        return client;
    }
}
