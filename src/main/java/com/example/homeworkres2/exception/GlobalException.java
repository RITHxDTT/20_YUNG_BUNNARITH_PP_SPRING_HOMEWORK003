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


    @ExceptionHandler(HandlerMethodValidationException.class)
    public ProblemDetail handleParameterValidation(HandlerMethodValidationException ex) {

        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        detail.setTitle("Invalid Parameter");
        detail.setDetail("Parameter validation failed (e.g. id must be > 0)");
        detail.setProperty("timestamp", Instant.now());

        return detail;
    }



    @ExceptionHandler(DuplicateEmailException.class)
    public ProblemDetail handleDuplicateEmail(DuplicateEmailException ex) {

        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        detail.setTitle("Duplicate Email");
        detail.setDetail(ex.getMessage());
        detail.setProperty("timestamp", Instant.now());

        return detail;
    }



    @ExceptionHandler(DuplicateName.class)
    public ProblemDetail handleDuplicateName(DuplicateName ex) {

        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
        detail.setTitle("Duplicate Name");
        detail.setDetail(ex.getMessage());
        detail.setProperty("timestamp", Instant.now());

        return detail;
    }


    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail handleNotFound(NotFoundExceptionHandler ex) {

        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        detail.setTitle("ID not Found");
        detail.setDetail(ex.getMessage());
        detail.setProperty("timestamp", Instant.now());

        return detail;
    }



//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ProblemDetail handleDatabaseError(DataIntegrityViolationException ex,
//                                             HttpServletRequest request) {
//
//        ProblemDetail detail = ProblemDetail.forStatus(HttpStatus.CONFLICT);
//        detail.setTitle("Name Conflict");
//        detail.setDetail("this name is already exist ! please write other name ");
//        detail.setProperty("path", request.getRequestURI());
//        detail.setProperty("timestamp", Instant.now());
//
//        return detail;
//    }

    @ExceptionHandler(GreaterException.class)
    public ProblemDetail greaterThan(GreaterException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setProperty("timestamp" , Instant.now());
//        problemDetail.setProperties("message", ex.getMessage());
        return  problemDetail;
    }


}
