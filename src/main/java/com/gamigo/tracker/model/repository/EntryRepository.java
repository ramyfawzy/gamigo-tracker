package com.gamigo.tracker.model.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.gamigo.tracker.model.Entry;

@EnableMongoRepositories
public interface EntryRepository extends MongoRepository<Entry, String> {
	
	Entry findById(ObjectId id);
	
	

}
