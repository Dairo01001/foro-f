package dev.dairo.api_f.Exception;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<List<ErrorResponse>> handleExpiredJwtException(ExpiredJwtException ex) {
        return ResponseEntity.status(401).body(List.of(new ErrorResponse("token", "Token expired")));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorResponse>> handleValidationException(MethodArgumentNotValidException ex) {
        var errors = ex.getFieldErrors()
                .stream()
                .map(ErrorResponse::fromFieldError)
                .toList();

        return ResponseEntity.badRequest().body(errors);
    }

    private record ErrorResponse(String field, String message) {
        public static ErrorResponse fromFieldError(FieldError fieldError) {
            return new ErrorResponse(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
