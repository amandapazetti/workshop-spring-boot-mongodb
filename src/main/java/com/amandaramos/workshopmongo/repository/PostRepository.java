package com.amandaramos.workshopmongo.repository;

import com.amandaramos.workshopmongo.dominio.Post;
import javafx.geometry.Pos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);

}


/*Em resumo, a interface PostRepository fornece métodos para acessar e
manipular dados de usuários no banco de dados MongoDB, seguindo o padrão
definido pelo Spring Data MongoDB. A anotação @Repository indica que esta
interface é um componente de repositório gerenciado pelo Spring.
 */