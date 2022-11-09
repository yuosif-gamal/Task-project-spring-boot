package com.example.springproject.controllers;

import com.example.springproject.serves.todoServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todos.todo;

import java.util.List;

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
        return new ResponseEntity<todo>(TodoServes.getByID(id), HttpStatus.OK);
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
