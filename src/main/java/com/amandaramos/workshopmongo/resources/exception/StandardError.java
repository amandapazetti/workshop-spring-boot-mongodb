package com.amandaramos.workshopmongo.resources.exception;

import java.io.Serializable;

//// Esta classe representa um erro padrão que será retornado como resposta em caso de exceção.
public class StandardError implements Serializable {

    // Identificador único de versão usado durante serialização e desserialização para garantir compatibilidade.
        private static final long serialVersionUID = 6916634323117872709L;




   //construindo atributos que serão retornados na resposta de erro
    private  Long timestamp; // Momento em que o erro ocorreu.
    private Integer status; // Código HTTP do erro.
    private String error; // Tipo de erro.
    private String message; // Mensagem de erro.
    private String path; // Caminho do recurso que causou o erro.


    // Construtor padrão.
    public StandardError() {

    }
    //Construindo construtor com parametros
    public StandardError(Long timestamp, Integer status, String error, String path, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
        this.message = message;

    }


//Usando Getters e Seterrs para acessar e modificar atributos
    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

/*Resumo: No geral, esta classe fornece uma estrutura básica para representar
 e lidar com erros de forma consistente em uma aplicação, facilitando a
 comunicação de informações sobre erros para os clientes ou usuários da
 aplicação.*/