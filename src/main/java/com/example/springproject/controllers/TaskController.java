package com.example.springproject.controllers;
import com.example.springproject.serves.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.springproject.modules.Task;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping(value = "/api/task")
public class TaskController {
    @Autowired
    private TaskServices taskService;
    @GetMapping("/all")
    public List<Task> findAll() {
        return taskService.findAll();
    }
    @GetMapping("/{id}")
    public Task findTaskById(@PathVariable Long id) {
        try {
            return taskService.getByID(id);
        }
        catch (NoSuchElementException ex){
            throw new NoSuchElementException(String.format("no such data with this id in data base " , id));
        }
    }
    @PostMapping("/add")
    public Task createNewTask(@RequestBody Task task) {
        return taskService.createNewTasK(task);
    }
    @PutMapping("/update/{id}")
    public String update(@PathVariable Long id , @RequestBody Task task){
        taskService.updateTask(id , task);
        return "Success";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Done";
    }
}