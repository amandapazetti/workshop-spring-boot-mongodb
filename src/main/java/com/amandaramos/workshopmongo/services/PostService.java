package com.amandaramos.workshopmongo.services;

import com.amandaramos.workshopmongo.dominio.Post;
import com.amandaramos.workshopmongo.repository.PostRepository;
import com.amandaramos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> user = repo.findById(id);
        if (user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado");
        }
        return user.get();
    }

    public List<Post> findByTitle(String text) {
        return repo.searchTitle(text);
    }


}
