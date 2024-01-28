package com.amandaramos.workshopmongo.services;

import com.amandaramos.workshopmongo.dominio.User;
import com.amandaramos.workshopmongo.repository.UserRepository;
import com.amandaramos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //instanciando pela injeção de denpendencia
    @Autowired
    private UserRepository repo;
    public List<User> findAll() {

    return repo.findAll();

    }

    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }


}
