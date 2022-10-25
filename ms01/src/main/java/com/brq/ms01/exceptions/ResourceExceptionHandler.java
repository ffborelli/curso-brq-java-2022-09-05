package com.brq.ms01.exceptions;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
* @ControllerAdvice permite manipular exceções de forma global.
* Para cada tipo de exceção, podemos manipular desde o status
* até a mensagem de retorno
* */

@ControllerAdvice
public class ResourceExceptionHandler {

    /* gostaria que o método abaixo trate exceções
        do tipo de validação de dados*/
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void methodValidationHandler(){

    }
}
