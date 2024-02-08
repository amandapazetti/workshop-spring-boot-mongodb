package com.amandaramos.workshopmongo.resources.exception;

import com.amandaramos.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/*Esta anotação marca a classe como um controlador de exceções global, que intercepta
exceções lançadas por todos os controladores da aplicação.*/
@ControllerAdvice

/*Declaração da classe ResourceExceptionHandler, responsável por manipular exceções em recursos.*/
public class ResourceExceptionHandler {

/* Esta anotação marca o método para tratar exceções do tipo ObjectNotFoundException.*/
    @ExceptionHandler(ObjectNotFoundException.class)

  /*Este método é chamado quando uma exceção ObjectNotFoundException é lançada.
   Ele recebe como parâmetros a exceção (e) e uma requisição HTTP (request).*/
    public ResponseEntity<StandardError> objecNotFound(ObjectNotFoundException e, HttpServletRequest request) {

        //Define o status da resposta como "404 - Not Found".
        HttpStatus status = HttpStatus.NOT_FOUND;


/*Cria um objeto StandardError, que encapsula informações sobre a exceção,
incluindo o horário em que ocorreu, o status HTTP, uma mensagem de erro,
 a mensagem da exceção e o URI da requisição.*/
        StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());

/*Retorna uma resposta HTTP com o status e o corpo definidos pelo objeto
StandardError. */
        return ResponseEntity.status(status).body(err);


    }


}

/*Resumo:
Este controlador de exceções intercepta exceções do tipo ObjectNotFoundException
lançadas por outros controladores na aplicação. Quando essa exceção ocorre,
ele retorna uma resposta HTTP com o status "404 - Not Found" e um corpo
contendo informações detalhadas sobre o erro, como a mensagem da exceção
e a URI da requisição que a originou. Isso fornece uma maneira consistente
de lidar com exceções de recurso não encontrado em toda a aplicação.*/