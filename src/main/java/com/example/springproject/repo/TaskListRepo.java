package com.example.springproject.repo;

import com.example.springproject.modules.TaskList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListRepo extends JpaRepository<TaskList, Long> {
}
