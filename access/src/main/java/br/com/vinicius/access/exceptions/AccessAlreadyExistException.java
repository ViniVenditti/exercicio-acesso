package br.com.vinicius.access.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED, reason = "Acesso já existe!!")
public class AccessAlreadyExistException extends RuntimeException {
}
