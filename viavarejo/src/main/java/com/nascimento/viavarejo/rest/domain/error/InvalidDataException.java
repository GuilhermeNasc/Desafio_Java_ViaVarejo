package com.nascimento.viavarejo.rest.domain.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidDataException extends Exception{
    public InvalidDataException(){
        super("InvalidDataException");
    }
}
