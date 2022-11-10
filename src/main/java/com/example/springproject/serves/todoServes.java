package com.example.springproject.serves;

import com.example.springproject.repo.todoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import modules.todo;

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

    public todo getByName(String name) {
        return TodoRepo.getByName(name);
    }
    public todo createNewTodo(todo Todo) {

        return TodoRepo.insert(Todo);
    }
    public void deleteTodo(String id) {
        TodoRepo.deleteById(id);
    }
    public void  deleteAll(){
        TodoRepo.deleteAll();
    }

}
