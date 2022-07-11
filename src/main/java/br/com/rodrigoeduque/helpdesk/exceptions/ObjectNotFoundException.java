package br.com.rodrigoeduque.helpdesk.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 7504161217456453538L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
