package com.amandaramos.workshopmongo.resources;

import com.amandaramos.workshopmongo.dominio.Post;
import com.amandaramos.workshopmongo.dominio.User;
import com.amandaramos.workshopmongo.dto.UserDTO;
import com.amandaramos.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")

public class UserResource {

    @Autowired
    private UserService service;
    //metodo para retornar uma lista de usuário

    @RequestMapping(method = RequestMethod.GET)
    // Método para retornar uma lista de usuários
    public ResponseEntity<List<UserDTO>> findAll() {
    // Obtém a lista de usuários do serviço
        List<User> list = service.findAll();
    // Converte a lista de usuários para uma lista de DTOs de usuário
        List<UserDTO> listDto = list.stream().map(UserDTO::new).collect(Collectors.toList());
    // Retorna a lista de DTOs de usuário na resposta HTTP
        return ResponseEntity.ok().body(listDto);

    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    // Método para encontrar um usuário por ID
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    // Encontra o usuário pelo ID usando o serviço
        User obj = service.findById(id);
    // Retorna o DTO do usuário encontrado na resposta HTTP
        return ResponseEntity.ok().body(new UserDTO(obj));

    }

    @RequestMapping(method = RequestMethod.POST)
    // Método para inserir um novo usuário
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
    // Converte o DTO do usuário para uma entidade de usuário e insere no banco de dados usando o serviço
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        // Cria uma URI para o novo usuário inserido e retorna na resposta HTTP
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    // Método para deletar um usuário por ID
    public ResponseEntity<Void> delete(@PathVariable String id) {
    // Deleta o usuário pelo ID usando o serviço
            service.delete(id);
    // Retorna uma resposta vazia (204 No Content) na resposta HTTP
            return ResponseEntity.noContent().build();

        }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    // Método para atualizar um usuário por ID
    public ResponseEntity<Void> update(@RequestBody UserDTO objDto, @PathVariable String id) {
        // Converte o DTO do usuário para uma entidade de usuário, atribui o ID e atualiza no banco de dados usando o serviço
            User obj = service.fromDTO(objDto);
            obj.setId(id);
            obj = service.update(obj);
        // Retorna uma resposta vazia (204 No Content) na resposta HTTP
            return ResponseEntity.noContent().build();
        }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    // Método para encontrar um posts por ID
    public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
        // Encontra o usuário pelo ID usando o serviço
        User obj = service.findById(id);
        // Retorna os posts do usuário encontrado na resposta HTTP
        return ResponseEntity.ok().body(obj.getPosts());

    }

    }

    /*Resumo:
    No código fornecido, a classe UserResource é responsável por mapear os
    endpoints da API REST para os métodos correspondentes na classe de serviço
    (UserService). Ela recebe as requisições HTTP, extrai os parâmetros
    necessários e passa esses dados para os métodos adequados na classe de
    serviço. Depois que a lógica de negócios é executada na camada de serviço,
    o controlador utiliza o resultado para construir a resposta HTTP apropriada
    e enviá-la de volta ao cliente.*/