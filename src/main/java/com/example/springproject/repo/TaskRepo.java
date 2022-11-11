package com.example.springproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springproject.modules.Task;

public interface TaskRepo extends JpaRepository<Task,Long> {
}