package br.com.rodrigoeduque.helpdesk.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

    private static final long serialVersionUID = -7581070186007866457L;

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(Long timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldError, String message) {
        this.errors.add(new FieldMessage(fieldError,message));
    }
}
