package com.amandaramos.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1l;


    public ObjectNotFoundException(String msg) {
        super((msg != null && !msg.isEmpty()) ? msg : getDefaultMessage());
    }

    private static String getDefaultMessage() {
        return "Objeto não encontrado";
    }

}