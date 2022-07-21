package com.samuelmessias.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.samuelmessias.workshopmongo.models.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
