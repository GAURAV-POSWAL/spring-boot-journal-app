package com.teamSpring.JournalApplication.repository;

import com.teamSpring.JournalApplication.entities.Journal;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalRepository extends MongoRepository<Journal, ObjectId> {}
