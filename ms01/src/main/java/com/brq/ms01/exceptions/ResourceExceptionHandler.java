package com.brq.ms01.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

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
    public void methodValidationHandler(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
            ){

//        StandardError standardError = new StandardError();
//        standardError.setStatus(400);
//        standardError.setPath("");

 // @Builder
        StandardError standardError = StandardError
                            .builder()
                            .timestamp(System.currentTimeMillis())
                            .status(HttpStatus.BAD_REQUEST.value())
                            //.error()
                            .path("")
                            .build();
    }
}
