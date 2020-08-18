package br.com.vinicius.door.controller;

import br.com.vinicius.door.mapper.DoorMapper;
import br.com.vinicius.door.model.DoorModel;
import br.com.vinicius.door.model.DoorResponse;
import br.com.vinicius.door.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/porta")
public class DoorController {

    @Autowired
    private DoorService service;
    @Autowired
    private DoorMapper mapper;

    @PostMapping
    public DoorResponse createDoor(@RequestBody DoorModel model){
        return service.creatDoor(mapper.to(model));
    }

}
