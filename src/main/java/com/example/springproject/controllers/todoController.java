package com.example.springproject.controllers;
import com.example.springproject.serves.todoServes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springproject.modules.todo;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/todo")
public class todoController {
    @Autowired
    private todoServes TodoServes;
    @GetMapping("/all")
    public List<todo> getAll() {
        return TodoServes.findAll();
    }
    @GetMapping("/{id}")
    public todo getTodoById(@PathVariable String id) {
        try {
            return TodoServes.getByID(id);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this id in data base " , id));
        }
    }
    @PostMapping("/add")
    public todo createNewTodo(@RequestBody todo Todo) {
        return TodoServes.createNewTodo(Todo);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable String id , @RequestBody todo Todo){
        TodoServes.updateTodo(id , Todo);
        return "Success";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTodo(@PathVariable String id) {
        TodoServes.deleteTodo(id);
        return "Done";
    }
    @DeleteMapping("/delete-all")
    public void deleteAll(){
        TodoServes.deleteAll();
    }
}