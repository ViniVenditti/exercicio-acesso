package br.com.vinicius.access.client;

import br.com.vinicius.access.configuration.ClientClientConfiguration;
import br.com.vinicius.access.model.ClientModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "client", configuration = ClientClientConfiguration.class)
public interface ClientClient {

    @GetMapping("/cliente/{idClient}")
    ClientModel getClient(@PathVariable Long idClient);

}
