package com.app.school.controllers;

import com.app.school.models.exceptions.BadRequestException;
import com.app.school.models.exceptions.EmailExistException;
import com.app.school.models.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

   @ExceptionHandler(ResourceNotFoundException.class)
   protected ResponseEntity<Object> handlerNotFound(RuntimeException ex, WebRequest request) {
      return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND, request);
   }

   @ExceptionHandler(BadRequestException.class)
   protected ResponseEntity<Object>  handlerBadRequest(RuntimeException ex, WebRequest request) {
      return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
   }

   @ExceptionHandler(EmailExistException.class)
   protected ResponseEntity<Object> handlerEmailExist(IllegalStateException ex, WebRequest request) {
      return handleExceptionInternal(ex, ex.getMessage() , new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
   }
}
