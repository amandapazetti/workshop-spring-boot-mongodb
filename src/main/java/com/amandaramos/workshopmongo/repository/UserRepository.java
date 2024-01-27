package com.amandaramos.workshopmongo.repository;

import com.amandaramos.workshopmongo.dominio.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserRepository extends MongoRepository <User, String> {



}
