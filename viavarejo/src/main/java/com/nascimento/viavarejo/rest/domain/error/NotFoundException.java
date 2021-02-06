package com.nascimento.viavarejo.rest.domain.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends Exception{
    public NotFoundException(){
        super("NotFoundException");
    }
}
