package com.example.springproject.controllers;

import com.example.springproject.serves.todoServes;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<todo> getAll() {
        return TodoServes.findAll();
    }

    @GetMapping("/get-by-id/{id}")
    public todo getTodoById(@PathVariable String id) {
        try {
            return TodoServes.getByID(id);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this id in data base " , id));
        }
    }
    @GetMapping("get-by-name/{name}")
    public todo getTodoByName(@PathVariable String name) {
        try {
           return TodoServes.getByName(name);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this name in database " , name));
        }
    }
    @PostMapping("/add-new")
    public todo createNewTodo(@RequestBody todo Todo) {
        return TodoServes.createNewTodo(Todo);
    }
    @PutMapping("/update/{id}/{name}")
    public String updateName(@PathVariable String name ,@PathVariable String id){
        TodoServes.updateTodo(name, id);
        return "Success";
    }
    @DeleteMapping("/delete{id}")
    public String deleteTodo(@PathVariable String id) {
        TodoServes.deleteTodo(id);
        return "Done";
    }
    @DeleteMapping("/delete-all")
    public String deleteAll(){
        TodoServes.deleteAll();
        return "Done";
    }
}
