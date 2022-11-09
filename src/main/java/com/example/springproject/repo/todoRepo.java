package com.example.springproject.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import todos.todo;

@Repository
public interface todoRepo extends MongoRepository<todo,String> {

}
