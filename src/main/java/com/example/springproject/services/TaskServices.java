package com.example.springproject.services;
import com.example.springproject.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.springproject.modules.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
    @Autowired
    private TaskRepo taskRepo;

    public List<Task> findAll() {
        return taskRepo.findAll();
    }
    public Task getByID(Long id) {
        return taskRepo.findById(id).get();
    }

    public Task createNewTasK(Task task) {

        return taskRepo.save(task);
    }
    public boolean deleteTask(Long id) {
        if (!taskRepo.existsById(id)){
            return false;
        }
        taskRepo.deleteById(id);
        return true;
    }
    public boolean updateTask(Long id , Task task){
        if (!taskRepo.existsById(id)){
            return false;
        }
        Optional<Task> t = taskRepo.findById(id);
        t.get().setTitle(task.getTitle());
        t.get().setDeadline(task.getDeadline());
        t.get().setDescription(task.getDescription());
        t.get().setStatus(task.isStatus());
        taskRepo.save(t.get());
        return true;
    }

}
