package com.amandaramos.workshopmongo.services;

import com.amandaramos.workshopmongo.dominio.User;
import com.amandaramos.workshopmongo.dto.UserDTO;
import com.amandaramos.workshopmongo.repository.UserRepository;
import com.amandaramos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/* Esta anotação marca a classe como um componente de serviço do Spring, o que significa
que ela é uma classe de serviço gerenciada pelo contêiner do Spring.*/
@Service
public class UserService {

 /*Esta anotação indica que o Spring deve injetar uma instância de
 UserRepository neste campo quando a classe UserService for criada.*/
    @Autowired

  /* Declaração de um campo privado chamado repo do tipo UserRepository.
  Este campo será usado para acessar e manipular dados de usuários
   no banco de dados.   */
    private UserRepository repo;

  /*O método findAll() da classe UserService retorna uma lista
   de todos os usuários presentes no banco de dados, usando o método
    findAll() fornecido pelo UserRepository injetado na classe.
     Isso permite que outras partes da aplicação obtenham facilmente
      todos os usuários armazenados no banco de dados MongoDB*/
    public List<User> findAll() {

        return repo.findAll();

    }

/*Este método busca um usuário pelo ID fornecido. Se o usuário for encontrado,
 ele é retornado. Caso contrário, uma exceção é lançada indicando que o objeto
  não foi encontrado.*/
    public User findById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    /*Este método insere um novo usuário no banco de dados. Ele utiliza o método save(obj)
    do UserRepository (repo) para salvar o objeto User fornecido como argumento
    no banco de dados MongoDB. Em seguida, retorna o objeto User que foi inserido
     no banco de dados.*/
    public User insert(User obj) {
        return repo.save(obj);
    }

    /*Este método exclui um usuário do banco de dados com base no ID fornecido.
     Ele utiliza o método deleteById(id) do UserRepository (repo) para excluir
     o usuário com o ID especificado do banco de dados MongoDB. O método não
     retorna nenhum valor, pois apenas executa a operação de exclusão.*/
    public  void delete(String id) {
      repo.deleteById(id);
    }

    /*Este método atualiza um usuário no banco de dados. Primeiro, ele busca
     o usuário com base no ID fornecido. Se o usuário for encontrado, os dados
     são atualizados com os novos valores. Em seguida, o usuário atualizado
      é salvo no banco de dados e retornado. Se o usuário não for encontrado,
      uma exceção é lançada indicando que o objeto não foi encontrado.*/
    public User update(User obj) {
        User newObj = repo.findById(obj.getId())
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    /*Este método copia os novos dados de um objeto User fornecido para outro objeto
    User que representa um usuário existente a ser atualizado.
    Ele atualiza os campos name e email do usuário existente com os novos valores fornecidos.*/
    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    /*Este método converte um objeto UserDTO em um objeto User,
    utilizando os dados fornecidos pelo UserDTO para inicializar os
     campos id, name e email do novo objeto User.*/
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }


}

/*Resumo:
A classe UserService gerencia operações relacionadas aos usuários da aplicação.
Ela fornece métodos para:
Consultar todos os usuários ou buscar um usuário pelo ID.
Inserir, atualizar e excluir usuários no banco de dados.
Converter objetos UserDTO em objetos User.
Esses métodos encapsulam a lógica de manipulação de usuários, fornecendo uma interface simples para interagir com o banco de dados.*/