package br.edu.iftm.pessoaapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PessoaNaoEncontradaAdvice {
    
    @ExceptionHandler
    ResponseEntity<String> employeeNotFoundHandler(PessoaNaoEncontradaException ex) {
        return new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}