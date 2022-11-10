package com.example.springproject.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import modules.todo;

import javax.management.Query;

@Repository
public interface todoRepo extends MongoRepository<todo,String> {
    todo getByName(String name);
}
