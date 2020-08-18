package br.com.vinicius.door.service;

import br.com.vinicius.door.entity.DoorEntity;
import br.com.vinicius.door.mapper.DoorMapper;
import br.com.vinicius.door.model.DoorResponse;
import br.com.vinicius.door.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoorService {

    @Autowired
    private DoorRepository repository;
    @Autowired
    private DoorMapper mapper;

    public DoorResponse creatDoor(DoorEntity entity) {
        return mapper.from(entity);
    }

}
