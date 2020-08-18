package br.com.vinicius.access.fallback;

import br.com.vinicius.access.client.ClientClient;
import br.com.vinicius.access.exceptions.ClientErrorException;
import br.com.vinicius.access.model.ClientModel;

public class ClientClientFallback implements ClientClient {
    @Override
    public ClientModel getClient(Long idClient) {
        throw new ClientErrorException();
    }
}
