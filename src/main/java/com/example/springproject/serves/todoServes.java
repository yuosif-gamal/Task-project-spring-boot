package com.example.springproject.serves;

import com.example.springproject.repo.todoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import todos.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service

public class todoServes {
    @Autowired
    private todoRepo TodoRepo;
    public List<todo> findAll() {
         return TodoRepo.findAll();
    }
    public todo getByID(String id) {
        return TodoRepo.findById(id).get();
    }

    public todo createNewTodo(todo Todo) {
       return TodoRepo.insert(Todo);
    }
    public void deleteTodo(String id){
        TodoRepo.deleteById(id);
    }

}
