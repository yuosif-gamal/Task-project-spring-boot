package com.example.springproject.errors;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;

public class notFoundException extends RuntimeException {
     public notFoundException(String message){
         super(message);
     }
     public HttpStatus getStatus(){
         return HttpStatus.NOT_FOUND;
     }
}
