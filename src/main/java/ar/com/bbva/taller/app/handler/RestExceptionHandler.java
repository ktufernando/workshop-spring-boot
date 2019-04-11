package ar.com.bbva.taller.app.handler;

import ar.com.bbva.taller.app.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by fer on 11/04/19.
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {BadCredentialsException.class})
    public ResponseEntity badCredentials(BadCredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                ErrorResponse.builder().status(HttpStatus.UNAUTHORIZED).message(e.getMessage()).build()
        );
    }
}
