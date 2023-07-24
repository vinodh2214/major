package com.quiz.main.repository;


import com.quiz.main.model.Result;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepo extends MongoRepository<Result, String> {
	
}
