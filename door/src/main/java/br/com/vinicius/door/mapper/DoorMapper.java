package br.com.vinicius.door.mapper;

import br.com.vinicius.door.entity.DoorEntity;
import br.com.vinicius.door.model.DoorModel;
import br.com.vinicius.door.model.DoorResponse;
import org.springframework.stereotype.Component;

@Component
public class DoorMapper {

    private DoorMapper() {}

    public DoorEntity to (DoorModel model) {
        DoorEntity entity = new DoorEntity();
        entity.setFloor(model.getFloor());
        entity.setRoom(model.getRoom());
        return entity;
    }

    public DoorResponse from (DoorEntity entity) {
        DoorResponse response = new DoorResponse();
        response.setId(entity.getId());
        response.setFloor(entity.getFloor());
        response.setRoom(entity.getRoom());
        return response;
    }

}
