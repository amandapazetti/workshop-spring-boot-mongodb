package com.amandaramos.workshopmongo.resources;

import com.amandaramos.workshopmongo.dominio.User;
import com.amandaramos.workshopmongo.dto.UserDTO;
import com.amandaramos.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    @Autowired
    private UserService service;
    //metodo para retornar uma lista de usuário

    @RequestMapping(method = RequestMethod.GET )
    public ResponseEntity<List<UserDTO>> findAll() {
       List<User> list = service.findAll();
       List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);

    }


}