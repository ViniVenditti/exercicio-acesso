package br.com.vinicius.door.service;

import br.com.vinicius.door.entity.DoorEntity;
import br.com.vinicius.door.exceptions.DoorNotFoundException;
import br.com.vinicius.door.mapper.DoorMapper;
import br.com.vinicius.door.model.DoorResponse;
import br.com.vinicius.door.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoorService {

    @Autowired
    private DoorRepository repository;
    @Autowired
    private DoorMapper mapper;

    public DoorResponse creatDoor(DoorEntity entity) {
        DoorEntity response = repository.save(entity);
        return mapper.from(response);
    }

    public DoorResponse getDoor(Long idDoor){
        Optional<DoorEntity> byId = repository.findById(idDoor);
        if(byId.isPresent())
            return mapper.from(byId.get());
        throw new DoorNotFoundException();
    }

}
