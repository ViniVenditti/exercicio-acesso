package br.com.vinicius.access.decoder;

import br.com.vinicius.access.exceptions.ClientNotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ClientClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        if(response.status() == 404)
            return new ClientNotFoundException();
        return errorDecoder.decode(methodKey, response);
    }
}
