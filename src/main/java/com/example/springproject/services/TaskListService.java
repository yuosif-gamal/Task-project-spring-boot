package com.example.springproject.services;

import com.example.springproject.modules.TaskList;
import com.example.springproject.repo.TaskListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskListService {
    @Autowired
    private TaskListRepo taskListRepo;
    // add list
    // remove list
    // find all tasks
    // sort deadline...
}
