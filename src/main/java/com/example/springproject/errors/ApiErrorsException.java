package com.example.springproject.errors;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiErrorsException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<ErrorDetails> handleApiEx(NotFoundException ex , WebRequest webRequest){
        ErrorDetails details = new ErrorDetails(ex.getMessage(),webRequest.getDescription(false));
        return new ResponseEntity<>(details , ex.getStatus());
    }

}
