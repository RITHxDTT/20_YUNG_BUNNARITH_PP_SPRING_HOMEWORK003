package com.example.homeworkres2.controller;


import com.example.homeworkres2.apiResponse.ApiRespone;
import com.example.homeworkres2.apiResponse.EventRespone;
import com.example.homeworkres2.apiResponse.EventRespone;
import com.example.homeworkres2.apiResponse.VenuesRespone;
import com.example.homeworkres2.exception.DuplicateName;
import com.example.homeworkres2.exception.GreaterException;
import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.repository.EventRepository;
import com.example.homeworkres2.request.VenuesRequest;
import com.example.homeworkres2.service.EventService;
import com.example.homeworkres2.service.VenuesService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class venuesController {
    private final VenuesService venuesService;


    @GetMapping
    public ResponseEntity<VenuesRespone> getAllVenues(@RequestParam @Positive int size, @RequestParam @Positive int page){
        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.getAllVenuse(size,page))
                .build();

        return ResponseEntity.ok(venuesRespone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenuesRespone> getByIdVenues(@PathVariable @Positive  int id){
        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.getById(id)).build();
        return ResponseEntity.ok(venuesRespone);
    }

    @PostMapping
    public ResponseEntity<VenuesRespone> createVenu(@RequestBody @Valid VenuesRequest request){

        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("created venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.createVenues(request)).build();
        return ResponseEntity.ok(venuesRespone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenuesRespone> updateVenu(@RequestBody VenuesRequest request, @PathVariable @Positive int id){

        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Update venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.updateVenues(request, id)).build();
        return ResponseEntity.ok(venuesRespone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VenuesRespone> deleteVenu(@PathVariable @Positive int id){
        venuesService.deleteVenues(id);
        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Delete venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
             .build();
        return ResponseEntity.ok(venuesRespone);
    }

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail  handlerExceptioon(NotFoundExceptionHandler ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setProperty("timestamp" , Instant.now());
        return  problemDetail;
    }

    @ExceptionHandler(GreaterException.class)
    public ProblemDetail greaterThan(GreaterException ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());
        problemDetail.setProperty("timestamp" , Instant.now());
        return  problemDetail;
    }

    @ExceptionHandler(DuplicateName.class)
    public  ProblemDetail duplicateNameException(DuplicateName duplicateName){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, duplicateName.getMessage());
        problemDetail.setProperty("timestamp" , LocalDate.now());
        problemDetail.setStatus(HttpStatus.CONFLICT);
        return problemDetail;
    }


}
