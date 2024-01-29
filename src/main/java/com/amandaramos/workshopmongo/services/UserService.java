package com.amandaramos.workshopmongo.services;

import com.amandaramos.workshopmongo.dominio.User;
import com.amandaramos.workshopmongo.dto.UserDTO;
import com.amandaramos.workshopmongo.repository.UserRepository;
import com.amandaramos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
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

    public User insert(User obj) {
        return repo.save(obj);
    }
    public  void delete(String id) {
      repo.deleteById(id);
    }

    public User update(User obj) {
        User newObj = repo.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}