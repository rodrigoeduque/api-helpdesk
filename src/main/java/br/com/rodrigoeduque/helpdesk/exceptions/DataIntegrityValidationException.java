package br.com.rodrigoeduque.helpdesk.exceptions;

public class DataIntegrityValidationException extends RuntimeException {
    private static final long serialVersionUID = 7504161217456453538L;

    public DataIntegrityValidationException(String message) {
        super(message);
    }

    public DataIntegrityValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
