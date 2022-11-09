package com.example.springproject.controllers;

import com.example.springproject.serves.todoServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todos.todo;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/v1")
public class todoController {
    @Autowired
    private todoServes TodoServes;

    @GetMapping(value = {"", "/get"})
    public ResponseEntity<List<todo>> getAll() {
        return new ResponseEntity<>(TodoServes.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<todo> getTodoById(@PathVariable String id) {
        try {
            return new ResponseEntity<todo>(TodoServes.getByID(id), HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this id in data base " , id));
        }
    }
    @PostMapping(value = {"", "/add"})
    public ResponseEntity<todo> createNewTodo(@RequestBody todo Todo) {
        return new ResponseEntity<>(TodoServes.createNewTodo(Todo), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
