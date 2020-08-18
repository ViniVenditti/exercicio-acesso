package br.com.vinicius.client.controller;

import br.com.vinicius.client.mapper.ClientMapper;
import br.com.vinicius.client.model.ClientModel;
import br.com.vinicius.client.model.ClientResponse;
import br.com.vinicius.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
public class ClientController {

    @Autowired
    public ClientService service;
    @Autowired
    public ClientMapper mapper;

    @PostMapping
    public ClientResponse createClient(@RequestBody ClientModel model) {
        return service.createClient(mapper.to(model));
    }

    @GetMapping("/{idClient}")
    public ClientResponse getClient(@PathVariable Long idClient) {
        return service.findClient(idClient);
    }

}
