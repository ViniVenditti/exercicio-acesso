package br.com.vinicius.access.client;

import br.com.vinicius.access.model.DoorModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "door")
public interface DoorClient {

    @GetMapping("/porta/{doorId}")
    DoorModel getDoor(@PathVariable Long doorId);

}
