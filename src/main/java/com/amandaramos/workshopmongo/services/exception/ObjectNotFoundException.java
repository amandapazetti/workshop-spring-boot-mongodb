package com.amandaramos.workshopmongo.services.exception;

// Esta classe representa uma exceção personalizada para quando um objeto não é encontrado.
public class ObjectNotFoundException extends RuntimeException {


    // Identificador único de versão usado durante serialização e desserialização para garantir compatibilidade.

    private static final long serialVersionUID = 6808114009209791227L;



    // Construtor que recebe uma mensagem de erro.
    public ObjectNotFoundException(String msg) {
        // Chama o construtor da superclasse RuntimeException com a mensagem fornecida,
        // ou com uma mensagem padrão se a mensagem fornecida for nula ou vazia.
        super((msg != null && !msg.isEmpty()) ? msg : getDefaultMessage());
    }

    // Método privado que retorna uma mensagem padrão caso nenhuma mensagem seja fornecida.
    private static String getDefaultMessage() {
        return "Objeto não encontrado";
    }

}

/*Resumo: Este código implementa uma classe de exceção personalizada chamada
ObjectNotFoundException, que é lançada quando um objeto não é encontrado em uma
operação de busca. Ele fornece flexibilidade para passar mensagens de erro
específicas ou usa uma mensagem padrão "Objeto não encontrado" se nenhuma
mensagem for fornecida. Essa classe é útil para sinalizar erros de busca em
operações de banco de dados ou em qualquer situação em que a ausência de um
objeto seja considerada uma condição excepcional.*/