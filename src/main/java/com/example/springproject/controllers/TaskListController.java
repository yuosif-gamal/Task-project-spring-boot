package com.example.springproject.controllers;

import com.example.springproject.modules.Task;
import com.example.springproject.modules.TaskList;
import com.example.springproject.services.TaskListService;
import com.example.springproject.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/task-list")
public class TaskListController {
    @Autowired
    private TaskListService taskListService;
    @Autowired
    private TaskService taskService;
    @PostMapping("/add")
    public String createNewList(@RequestBody TaskList taskList) {
        boolean t =  taskListService.addList(taskList);
        if (t == true) {
            return "Created";
        }
        return "this id already exist";
    }
    @GetMapping("/{list_id}")
    public List<Task> findAllTasksInSpecificList(@PathVariable Long list_id) {
        List<Task> all_task = taskListService.findAllSpecificInList(list_id);
        return all_task;
    }

    @DeleteMapping("/delete/{list_id}")
    public String deleteTask(@PathVariable Long list_id) {
        if (taskListService.deleteList(list_id) == true)
        {
            return "Deleted";
        }
        return "Wrong id";
    }
    @GetMapping("/sorted/{list_id}")
    public List<Task> findAllTasksInSpecificListSorted(@PathVariable Long list_id) {
        List<Task> all_task = taskListService.findAllInSpecificListSorted(list_id);
        return all_task;
    }
}
