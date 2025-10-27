package com.teamSpring.JournalApplication.repository;

import com.teamSpring.JournalApplication.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {

    User findByUsername(String username);

}
