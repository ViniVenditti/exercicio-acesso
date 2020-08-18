package br.com.vinicius.access.service;

import br.com.vinicius.access.client.ClientClient;
import br.com.vinicius.access.client.DoorClient;
import br.com.vinicius.access.entity.AccessEntity;
import br.com.vinicius.access.exceptions.AccessAlreadyExistException;
import br.com.vinicius.access.exceptions.AccessNotFoundException;
import br.com.vinicius.access.mapper.AccessMapper;
import br.com.vinicius.access.model.AccessModel;
import br.com.vinicius.access.model.ClientModel;
import br.com.vinicius.access.model.DoorModel;
import br.com.vinicius.access.repository.AccessRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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
        if(verifyIfAccessExistAndClientAndDoor(entity)){
            throw new AccessAlreadyExistException();
        }
        AccessEntity save = repository.save(entity);
        return mapper.to(save);
    }

    @Transactional
    public void deleteAccess(AccessEntity entity){
        if(!verifyIfAccessExistAndClientAndDoor(entity)){
            throw new AccessNotFoundException();
        }
        repository.removeByDoorIdAndClientId(entity.getDoorId(), entity.getClientId());
    }

    public AccessModel getAccess(AccessEntity entity){
        if(verifyIfAccessExistAndClientAndDoor(entity)){
            return mapper.to(entity);
        }
        throw new AccessNotFoundException();
    }

    public List<AccessModel> getListAccess() {
        List<AccessEntity> all = repository.findAll();
        if(all.isEmpty())
            throw new AccessNotFoundException();
        return all.stream().map(entity -> mapper.to(entity)).collect(Collectors.toList());
    }

    private boolean verifyIfAccessExistAndClientAndDoor(AccessEntity entity) {
        ClientModel client = clientClient.getClient(entity.getClientId());
        DoorModel door = doorClient.getDoor(entity.getDoorId());
        return repository.exists(Example.of(entity));
    }
}
