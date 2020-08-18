package br.com.vinicius.access.controller;

import br.com.vinicius.access.entity.AccessEntity;
import br.com.vinicius.access.mapper.AccessMapper;
import br.com.vinicius.access.model.AccessModel;
import br.com.vinicius.access.service.AccessService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acesso")
public class AccessController {

    private AccessMapper mapper;
    private AccessService service;

    public AccessController(AccessMapper mapper, AccessService service) {
        this.mapper = mapper;
        this.service = service;
    }

    @PostMapping
    public AccessModel createAccess(@RequestBody AccessModel model){
        return service.registryAccess(mapper.from(model));
    }

    @DeleteMapping("/{clientId}/{doorId}")
    public void deleteAccess(@PathVariable Long clientId, @PathVariable Long doorId){
        AccessEntity entity = setEntity(clientId, doorId);
        service.deleteAccess(entity);
    }

    @GetMapping("/{clientId}/{doorId}")
    public AccessModel getAccess(@PathVariable Long clientId, @PathVariable Long doorId) {
        AccessEntity entity = setEntity(clientId, doorId);
        return service.getAccess(entity);
    }

    private AccessEntity setEntity(Long clientId, Long doorId) {
        AccessEntity entity = new AccessEntity();
        entity.setDoorId(doorId);
        entity.setClientId(clientId);
        return entity;
    }

}
