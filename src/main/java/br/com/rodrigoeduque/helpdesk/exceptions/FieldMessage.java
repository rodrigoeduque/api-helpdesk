package br.com.rodrigoeduque.helpdesk.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private static final long serialVersionUID = 4581348588173793282L;

    private String fieldName;
    private String message;

    public FieldMessage() {
        super();
    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
