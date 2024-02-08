package com.amandaramos.workshopmongo.dto;

import com.amandaramos.workshopmongo.dominio.User;

import java.io.Serializable;

/*Declaração da classe UserDTO, que implementa a interface Serializable.
Isso significa que objetos desta classe podem ser serializados e desserializados. */
public class AuthorDTO implements Serializable {
    // Definição de um número de série estático para controle de versão durante a serialização/desserialização de objetos
    private  static  final long serialVersionUID = 1L;

    //Declaração dos atributos
    private  String id;
    private String name;

    /*Este construtor não recebe argumentos e não faz nada além de inicializar
     um objeto UserDTO com os valores padrão.*/
    public  AuthorDTO() {

    }
    /*Construtor da classe UserDTO que recebe um objeto User como argumento.*/
    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    //Métodos getters e setters para acessar e modificar os atributos
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/*Em resumo, a classe DTO (AuthorDTO, neste caso) fornece uma estrutura
flexível e eficiente para transferir dados de usuários entre diferentes
partes da sua aplicação, contribuindo para uma arquitetura mais modular,
desacoplada e escalável.*/