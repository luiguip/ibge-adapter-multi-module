package com.github.luiguip.ibge_adapter_multi_module.application.controller;

import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceClientException;
import com.github.luiguip.ibge_adapter_multi_module.domain.exception.PersistenceServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PersistenceServerException.class)
    public ResponseEntity<String> persistenceServerException(PersistenceServerException persistenceServerException) {
        log.error("", persistenceServerException);
        return ResponseEntity.internalServerError().body(persistenceServerException.getMessage());
    }

    @ExceptionHandler(PersistenceClientException.class)
    public ResponseEntity<String> persistenceServerException(PersistenceClientException persistenceClientException) {
        log.error("", persistenceClientException);
        return ResponseEntity.internalServerError().body(persistenceClientException.getMessage());
    }
}
