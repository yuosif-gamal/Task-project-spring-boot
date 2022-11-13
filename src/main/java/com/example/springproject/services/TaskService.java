package com.example.springproject.services;

import com.example.springproject.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springproject.modules.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepo taskRepo;
    public List<Task> findAll() {
        return taskRepo.findAll();
    }

    public Task getByID(Long id) {
        return taskRepo.findById(id).get();
    }

    public boolean deleteTask(Long id) {
        if (!taskRepo.existsById(id)) {
            return false;
        }
        taskRepo.deleteById(id);
        return true;
    }

    public int updateTask(Long id, Task task) {
        if (!taskRepo.existsById(id)) {
            return 0;
        }
        Optional<Task> t = taskRepo.findById(id);
        if (task.getId() == null){
            return 2;
        }
        if (task.getDeadline() == null){
            return 2;
        }
        if (task.getDescription() == null){
            return 2;
        }
        if (task.isStatus() != true && task.isStatus() != false){
            return 2;
        }
        if (task.getTitle() == null){
            return 2;
        }
        t.get().setTitle(task.getTitle());
        t.get().setDeadline(task.getDeadline());
        t.get().setDescription(task.getDescription());
        t.get().setStatus(task.isStatus());
        taskRepo.save(t.get());
        return 1;
    }

    public boolean createNewTasK(Task task) {
        taskRepo.save(task);
        return true;
    }
    //add task to list ...  api ... id task .. id list (move-to-list/{id}/{list_id})
    //remove task from list


}
