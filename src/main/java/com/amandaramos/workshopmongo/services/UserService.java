package com.amandaramos.workshopmongo.services;

import com.amandaramos.workshopmongo.dominio.User;
import com.amandaramos.workshopmongo.repository.UserRepository;
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




}
