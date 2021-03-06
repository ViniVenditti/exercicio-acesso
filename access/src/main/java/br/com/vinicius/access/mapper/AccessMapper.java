package br.com.vinicius.access.mapper;

import br.com.vinicius.access.entity.AccessEntity;
import br.com.vinicius.access.model.AccessModel;
import br.com.vinicius.access.model.AccessModelLog;
import org.springframework.stereotype.Component;

@Component
public class AccessMapper {
    private AccessMapper (){}

    public AccessEntity from (AccessModel model){
        AccessEntity entity = new AccessEntity();
        entity.setClientId(model.getClientId());
        entity.setDoorId(model.getDoorId());
        return entity;
    }

    public AccessModel to (AccessEntity entity){
        AccessModel model = new AccessModel();
        model.setClientId(entity.getClientId());
        model.setDoorId(entity.getDoorId());
        return model;
    }

    public AccessModelLog to (AccessEntity entity, boolean access){
        AccessModelLog log = new AccessModelLog();
        log.setClientId(entity.getClientId());
        log.setDoorId(entity.getDoorId());
        log.setAccess(access);
        return log;
    }
}
