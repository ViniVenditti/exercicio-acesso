package br.com.vinicius.access.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY, reason = "Microserviço de Portas está fora!!")
public class DoorErrorException extends RuntimeException {
}
