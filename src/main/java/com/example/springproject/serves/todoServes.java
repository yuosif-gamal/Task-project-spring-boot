package com.example.springproject.serves;
import com.example.springproject.repo.todoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springproject.modules.todo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        return TodoRepo.save(Todo);
    }
    public void deleteTodo(String id) {
        TodoRepo.deleteById(id);
    }
    public void updateTodo(String id , todo Todo){
        Optional<todo> t = TodoRepo.findById(id);
        t.get().setName(Todo.getName());
        t.get().setAge(Todo.getAge());
        TodoRepo.save(t.get());
    }
    public void  deleteAll(){
        TodoRepo.deleteAll();
    }

}
