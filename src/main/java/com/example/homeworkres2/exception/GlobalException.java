package com.example.homeworkres2.exception;

import com.example.homeworkres2.apiResponse.ApiRespone;
import com.example.homeworkres2.apiResponse.VenuesRespone;
import com.example.homeworkres2.model.Venuse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice

public class GlobalException {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleValidationException(MethodArgumentNotValidException ex) {
        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        Map<String, Object> errors = new HashMap<>();

        for (FieldError e : ex.getBindingResult().getFieldErrors()) {

            if ("email".equals(e.getField())) {
                errors.put(e.getField(), "Invalid email format");
            } else {
                errors.put(e.getField(), e.getDefaultMessage());
            }
        }

        detail.setProperty("error", errors);
        return detail;
    }


    @ExceptionHandler(DataIntegrityViolationException.class)
    public ProblemDetail handleDuplicate(DataIntegrityViolationException ex, HttpServletRequest request) {

        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.CONFLICT);

        detail.setTitle("Conflict");
        detail.setDetail( "This name already exists ! ");

        detail.setProperty("timestamp", Instant.now());
        detail.setProperty("instance", request.getRequestURI());
        detail.setType(URI.create("http://localhost:8080/errors/duplicate-user"));

        return detail;
    }
}
