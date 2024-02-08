package com.amandaramos.workshopmongo.repository;

import com.amandaramos.workshopmongo.dominio.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}


/*Em resumo, a interface PostRepository fornece métodos para acessar e
manipular dados de usuários no banco de dados MongoDB, seguindo o padrão
definido pelo Spring Data MongoDB. A anotação @Repository indica que esta
interface é um componente de repositório gerenciado pelo Spring.
 */