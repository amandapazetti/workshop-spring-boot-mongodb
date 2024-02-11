package com.amandaramos.workshopmongo.repository;

import com.amandaramos.workshopmongo.dominio.Post;
import javafx.geometry.Pos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

   @Query("{ 'title': { $regex: ?0, $options: 'i' }}")
    List<Post> searchTitle(String text);
    List<Post> findByTitleContainingIgnoreCase(String text);

    @Query("{ $and: [ { date: { $gte: ?1, $lte: ?2 } }, { $or:[ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);

}


/*Em resumo, a interface PostRepository fornece métodos para acessar e
manipular dados de usuários no banco de dados MongoDB, seguindo o padrão
definido pelo Spring Data MongoDB. A anotação @Repository indica que esta
interface é um componente de repositório gerenciado pelo Spring.
 */