package espe.edu.ec.servicios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.ALREADY_REPORTED)
public class ExisteException extends RuntimeException {

    public ExisteException(String message) {
        super(message);
    }
}