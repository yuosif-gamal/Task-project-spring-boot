package com.example.springproject.controllers;

import com.example.springproject.serves.todoServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import modules.todo;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api")
public class todoController {
    @Autowired
    private todoServes TodoServes;

    @GetMapping("/get-all")
    public ResponseEntity<List<todo>> getAll() {
        return new ResponseEntity<>(TodoServes.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<todo> getTodoById(@PathVariable String id) {
        try {
            return new ResponseEntity<todo>(TodoServes.getByID(id), HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this id in data base " , id));
        }
    }
    @GetMapping("get-by-name/{name}")
    public ResponseEntity<todo> getTodoByName(@PathVariable String name) {
        try {
            return new ResponseEntity<todo>(TodoServes.getByName(name), HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this name in database " , name));
        }
    }
    @PostMapping("/add-new")
    public ResponseEntity<todo> createNewTodo(@RequestBody todo Todo) {
        return new ResponseEntity<>(TodoServes.createNewTodo(Todo), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String id) {
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAll(){
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
