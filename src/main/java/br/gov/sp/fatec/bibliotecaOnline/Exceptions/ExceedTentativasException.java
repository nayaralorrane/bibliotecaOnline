package br.gov.sp.fatec.bibliotecaOnline.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
public class ExceedTentativasException extends RuntimeException {
    private String message;
    private static final long serialVersionUID = -1634540996461722583L;

    public ExceedTentativasException() {
        super();
    }

    public ExceedTentativasException(String message) {
        super(message);
        this.message = message;
    }

    public ExceedTentativasException(Throwable cause) {
        super(cause);
    }

    public ExceedTentativasException(String message, Throwable cause) {
        super(message, cause);
    }
}