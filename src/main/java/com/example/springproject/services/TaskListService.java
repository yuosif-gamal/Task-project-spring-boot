package com.example.springproject.services;

import com.example.springproject.modules.Task;
import com.example.springproject.modules.TaskList;
import com.example.springproject.repo.TaskListRepo;
import com.example.springproject.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskListService {
    @Autowired
    private TaskListRepo taskListRepo;
    @Autowired
    private TaskRepo taskRepo;

    public boolean deleteList(Long list_id) {
        if  (!taskListRepo.existsById(list_id)){
            return false;
        }
        else {
            List<Task> allTasks = taskRepo.findAll();
            for (Task it:  allTasks){
                if (it.getList_id() == list_id){
                    Optional<Task> temp = taskRepo.findById(it.getId());
                    temp.get().setList_id(null);
                    taskRepo.save(temp.get());
                }
            }
            return true;
        }
    }

    public boolean addList(TaskList taskList) {
        taskListRepo.save(taskList);
        return true;
    }

    public List<Task> findAllSpecificInList(Long list_id) {
        List<Task> allTasks = taskRepo.findAll();
        List<Task> res = new ArrayList<>();
        for (Task it:  allTasks){
            if (it.getList_id() == list_id){
                res.add(it);
            }
        }
        return res;
    }

    public List<Task> findAllInSpecificListSorted(Long list_id) {
        List<Task> allTasks = taskRepo.findAll();
        List<Task> res = new ArrayList<>();
        for (Task it:  allTasks){
            if (it.getList_id() == list_id){
                res.add(it);
            }
        }
        Collections.sort(res, Comparator.comparing(Task::getDeadline));
        return res;

    }

        public List<TaskList> findAllLists() {
            return taskListRepo.findAll();

    }


}
