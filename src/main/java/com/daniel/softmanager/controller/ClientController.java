package com.daniel.softmanager.controller;

import com.daniel.softmanager.persistence.entity.Client;
import com.daniel.softmanager.service.ClientService;
import com.daniel.softmanager.service.dto.ClientInDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client create(@RequestBody ClientInDTO clientInDTO) {
        return this.clientService.create(clientInDTO);
    }

    @GetMapping("/{dni}")
    public Client findByDni(@PathVariable("dni") String dni) {
        return this.clientService.findByDni(dni);
    }
}
