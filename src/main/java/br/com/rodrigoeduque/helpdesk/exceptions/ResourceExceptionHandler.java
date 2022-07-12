package br.com.rodrigoeduque.helpdesk.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException ex, HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityValidationException.class)
    public ResponseEntity<StandardError> objectNotFoundException(DataIntegrityValidationException ex, HttpServletRequest request) {

        StandardError error = new StandardError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> objectNotFoundException(MethodArgumentNotValidException ex, HttpServletRequest request) {

        ValidationError errors = new ValidationError(System.currentTimeMillis(),
                HttpStatus.BAD_REQUEST.value(),
                "Erro na validação de campos",
                request.getRequestURI());

        for (FieldError e : ex.getBindingResult().getFieldErrors()) {
            errors.addError(e.getField(), e.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}
