package com.amandaramos.workshopmongo.dominio;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/*Essa anotação é usada em conjunto com o Spring Data MongoDB para mapear
 essa classe para um documento no MongoDB.*/
@Document(collection="user")
public class User  implements Serializable {
    private static final long serialVersionUID = 1L;
    //criação atributos
   @Id // Anotação para indicar que este atributo será o ID do documento no MongoDB
    private String id;
    private String name;
    private String email;

    //criação construtor vazio

    // Construtor padrão
    public  User() {

    }

    //construtor parametrizado
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters e Setters para acessar e modificar os atributos da classe
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


    /* Essa anotação indica que o método equals() está sobrescrevendo o método
    equals() da classe pai, garantindo
    que estamos substitua corretamente o método de comparação de objetos*/
    @Override

   /*Este método é usado para verificar se dois objetos são iguais.
   Ele recebe um objeto (o) como parâmetro e retorna true se os
    objetos forem iguais e false caso contrário.*/
    public boolean equals(Object o) {

         /*Este é um caso de verificação rápida. Ele verifica se o objeto passado
       como argumento (o) é exatamente o mesmo objeto que o objeto atual (this).
        Se forem os mesmos objetos na memória, não há necessidade de continuar
         a comparação e podemos retornar true imediatamente.*/
        if (this == o) return true;

        /*Aqui, estamos verificando se o objeto passado (o) é null ou se
         pertence a uma classe diferente da classe atual (Post).
          Se uma dessas condições for verdadeira, os objetos não podem
          ser iguais e retornamos false.*/
        if (o == null || getClass() != o.getClass()) return false;
        //Convertendo o objeto passado (o) para um objeto da classe Post, para que possamos comparar seus atributos
        User user = (User) o;
        /*comparando os IDs dos objetos Post. Se os IDs forem iguais, consideramos os objetos
        Post como iguais e retornamos true; caso contrário, retornamos false.*/
        return Objects.equals(id, user.id);
    }

    //Esta anotação indica que o método hashCode() está substituindo um método de mesmo nome da superclasse.
    @Override
    //Aqui declaramos o método hashCode(), que retorna um valor inteiro (int). Este método é público, o que significa que pode ser acessado de fora da classe.
    public int hashCode() {
        /*Esta linha calcula o código de hash do objeto com base no atributo id. O método Objects.hash() é uma maneira conveniente
       de calcular um código de hash combinando vários valores em um único código
       de hash. Neste caso, estamos usando apenas o valor do atributo id para
        calcular o código de hash.*/
        return Objects.hash(id);
    }
}
