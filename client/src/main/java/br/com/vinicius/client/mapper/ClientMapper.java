package br.com.vinicius.client.mapper;

import br.com.vinicius.client.entity.ClientEntity;
import br.com.vinicius.client.model.ClientModel;
import br.com.vinicius.client.model.ClientResponse;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {

    private ClientMapper (){}

    public ClientResponse from (ClientEntity entity) {
        ClientResponse response = new ClientResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        return response;
    }

    public ClientEntity to (ClientModel model) {
        ClientEntity entity = new ClientEntity();
        entity.setName(model.getName());
        return entity;
    }

}
