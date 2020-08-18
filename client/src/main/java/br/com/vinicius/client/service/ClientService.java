package br.com.vinicius.client.service;

import br.com.vinicius.client.entity.ClientEntity;
import br.com.vinicius.client.exceptions.ClientNotFoundException;
import br.com.vinicius.client.mapper.ClientMapper;
import br.com.vinicius.client.model.ClientResponse;
import br.com.vinicius.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientMapper mapper;
    @Autowired
    private ClientRepository repository;

    public ClientResponse createClient(ClientEntity entity) {
        ClientEntity newClient = repository.save(entity);
        return mapper.from(newClient);
    }

    public ClientResponse findClient(Long idClient) {
        Optional<ClientEntity> byId = repository.findById(idClient);
        if(byId.isPresent())
            return mapper.from(byId.get());
        throw new ClientNotFoundException();
    }


}
