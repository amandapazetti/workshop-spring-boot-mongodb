package com.amandaramos.workshopmongo.repository;

import com.amandaramos.workshopmongo.dominio.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
