package com.example.homeworkres2.controller;

import com.example.homeworkres2.apiResponse.AttendeeResponse;
import com.example.homeworkres2.exception.DuplicateEmailException;
import com.example.homeworkres2.exception.DuplicateName;
import com.example.homeworkres2.exception.GreaterException;
import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.request.AttendeeRequest;
import com.example.homeworkres2.service.AttendeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
public class AttendeeController {

    private final AttendeeService attendeeService;


    @GetMapping
    public ResponseEntity<AttendeeResponse> getAllVenues(@RequestParam int size, @RequestParam int page){
        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.getAllAttendee(size,page))
                .build();

        return ResponseEntity.ok(attendeeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendeeResponse> getByIdAttendee(@PathVariable @Valid int id){
        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Retrieved Event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.getById(id)).build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @PostMapping
    public ResponseEntity<AttendeeResponse> createAttendee(@RequestBody @Valid AttendeeRequest request){

        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("created event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.createAttendee(request)).build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendeeResponse> updateAttendee(@RequestBody @Valid AttendeeRequest request, @PathVariable int id){

        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Update Attendee successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.updateAttendee(request, id)).build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AttendeeResponse> deleteAttendee(@PathVariable @Valid int id){
        attendeeService.deleteAttendee(id);
        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Delete Attendee successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload("completed ")
                .build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail handlerExceptioon(NotFoundExceptionHandler ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setProperty("timestamp" , Instant.now());
        return  problemDetail;
    }
    @ExceptionHandler(DuplicateEmailException.class)
    public  ProblemDetail duplicateEmailException(DuplicateEmailException duplicateEmailException){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, duplicateEmailException.getMessage());
        problemDetail.setProperty("timestamp" , LocalDate.now());
        problemDetail.setStatus(HttpStatus.CONFLICT);
        return problemDetail;
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

