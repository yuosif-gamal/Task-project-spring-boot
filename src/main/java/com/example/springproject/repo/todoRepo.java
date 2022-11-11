package com.example.springproject.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import modules.todo;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface todoRepo extends MongoRepository<todo,String> {
    todo getByName(String name);
}