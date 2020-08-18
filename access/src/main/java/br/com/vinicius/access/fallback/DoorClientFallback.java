package br.com.vinicius.access.fallback;

import br.com.vinicius.access.client.DoorClient;
import br.com.vinicius.access.exceptions.DoorErrorException;
import br.com.vinicius.access.model.DoorModel;

public class DoorClientFallback implements DoorClient {
    @Override
    public DoorModel getDoor(Long doorId) {
        throw new DoorErrorException();
    }
}
