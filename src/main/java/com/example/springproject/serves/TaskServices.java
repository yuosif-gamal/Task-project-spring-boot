package com.example.springproject.serves;
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
    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }
    public void updateTask(Long id , Task task){
        Optional<Task> t = taskRepo.findById(id);
        t.get().setName(task.getName());
        t.get().setAge(task.getAge());
        taskRepo.save(t.get());
    }
    public void  deleteAll(){
        taskRepo.deleteAll();
    }

}
