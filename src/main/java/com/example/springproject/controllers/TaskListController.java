package com.example.springproject.controllers;

import com.example.springproject.modules.TaskList;
import com.example.springproject.services.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/list-task")
public class TaskListController {
    @Autowired
    private TaskListService listOfTasksServices;
    @PostMapping("/add")
    public String createNewList(@RequestBody TaskList taskList){
        boolean t = listOfTasksServices.createNewLists(taskList);
        if (t == true) {
            return "Created";
        }
        return "this id already exist";
    }
}
