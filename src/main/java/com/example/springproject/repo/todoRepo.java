package com.example.springproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springproject.modules.todo;

public interface todoRepo extends JpaRepository<todo,String> {
    todo getByName(String name);
}