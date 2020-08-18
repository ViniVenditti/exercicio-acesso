package br.com.vinicius.access.service;

import br.com.vinicius.access.client.ClientClient;
import br.com.vinicius.access.client.DoorClient;
import br.com.vinicius.access.entity.AccessEntity;
import br.com.vinicius.access.mapper.AccessMapper;
import br.com.vinicius.access.model.AccessModel;
import br.com.vinicius.access.model.ClientModel;
import br.com.vinicius.access.model.DoorModel;
import br.com.vinicius.access.repository.AccessRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccessService {

    private AccessRepository repository;
    private AccessMapper mapper;
    private ClientClient clientClient;
    private DoorClient doorClient;

    public AccessService(AccessRepository repository, AccessMapper mapper, ClientClient clientClient, DoorClient doorClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.clientClient = clientClient;
        this.doorClient = doorClient;
    }

    public AccessModel registryAccess(AccessEntity entity){
        verifyClientAndDoor(entity);
        AccessEntity save = repository.save(entity);
        return mapper.to(save);
    }

    @Transactional
    public void deleteAccess(AccessEntity entity){
        verifyClientAndDoor(entity);
        repository.removeByDoorIdAndClientId(entity.getDoorId(), entity.getClientId());
    }

    public AccessModel getAccess(AccessEntity entity){
        verifyClientAndDoor(entity);
        boolean exists = repository.exists(Example.of(entity));
        if(exists){
            return mapper.to(entity);
        }
        return null;
    }

    private void verifyClientAndDoor(AccessEntity entity) {
        ClientModel client = clientClient.getClient(entity.getClientId());
        DoorModel door = doorClient.getDoor(entity.getDoorId());
    }
}
