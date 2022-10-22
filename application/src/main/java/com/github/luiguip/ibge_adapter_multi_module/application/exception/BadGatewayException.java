package com.github.luiguip.ibge_adapter_multi_module.application.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

@ResponseStatus(BAD_GATEWAY)
public class BadGatewayException extends RuntimeException{

    public BadGatewayException(String message) {
        super(message);
    }
}
