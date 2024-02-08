package com.amandaramos.workshopmongo.repository;

import com.amandaramos.workshopmongo.dominio.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/* Esta anotação é usada para marcar a interface como um componente do
tipo repositório. Isso permite que o Spring reconheça e gerencie essa
 interface automaticamente, fornecendo recursos adicionais,
 como injeção de dependência.*/
@Repository
public interface UserRepository extends MongoRepository <User, String> {



}

/*Em resumo, a interface UserRepository fornece métodos para acessar e
manipular dados de usuários no banco de dados MongoDB, seguindo o padrão
definido pelo Spring Data MongoDB. A anotação @Repository indica que esta
interface é um componente de repositório gerenciado pelo Spring.
 */