package com.amandaramos.workshopmongo.dto;

import com.amandaramos.workshopmongo.dominio.User;

import java.io.Serializable;

/*Declaração da classe UserDTO, que implementa a interface Serializable.
Isso significa que objetos desta classe podem ser serializados e desserializados. */
public class UserDTO  implements Serializable {

    // Definição de um número de série estático para controle de versão durante a serialização/desserialização de objetos
    private  static  final long serialVersionUID = 1L;

    //Declaração dos atributos
    private  String id;
    private  String name;
    private  String email;

/*Este construtor não recebe argumentos e não faz nada além de inicializar
um objeto UserDTO com os valores padrão.*/
    public UserDTO() {

    }
/*Construtor da classe UserDTO que recebe um objeto User como argumento.*/
    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
         email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

/*Em resumo, a classe DTO (UserDTO, neste caso) fornece uma estrutura
flexível e eficiente para transferir dados de usuários entre diferentes
partes da sua aplicação, contribuindo para uma arquitetura mais modular,
desacoplada e escalável.*/