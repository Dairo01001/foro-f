package dev.dairo.api_f.Exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class ErrorHandler {

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
