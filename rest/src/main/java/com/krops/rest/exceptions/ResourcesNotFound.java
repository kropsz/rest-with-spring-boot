package com.krops.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourcesNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ResourcesNotFound(String ex){
        super(ex);
    }
}