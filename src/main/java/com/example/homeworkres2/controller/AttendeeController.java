package com.example.homeworkres2.controller;

import com.example.homeworkres2.apiResponse.AttendeeResponse;
import com.example.homeworkres2.exception.DuplicateEmailException;
import com.example.homeworkres2.exception.DuplicateName;
import com.example.homeworkres2.exception.GreaterException;
import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.request.AttendeeRequest;
import com.example.homeworkres2.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.constraints.Positive;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
@Validated
public class AttendeeController {

    private final AttendeeService attendeeService;


    @GetMapping
    public ResponseEntity<AttendeeResponse> getAllVenues(@RequestParam  int size, @RequestParam int page) {
        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.getAllAttendee(size, page))
                .build();

        return ResponseEntity.ok(attendeeResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttendeeResponse> getByIdAttendee(@PathVariable  int id) {
        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Retrieved Event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.getById(id)).build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @PostMapping
    public ResponseEntity<AttendeeResponse> createAttendee(@RequestBody   AttendeeRequest request) {

        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("created event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.createAttendee(request)).build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttendeeResponse> updateAttendee(@RequestBody   AttendeeRequest request, @PathVariable int id) {

        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Update Attendee successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(attendeeService.updateAttendee(request, id)).build();
        return ResponseEntity.ok(attendeeResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AttendeeResponse> deleteAttendee(@PathVariable   int id) {
        attendeeService.deleteAttendee(id);
        AttendeeResponse attendeeResponse = AttendeeResponse.builder()
                .message("Delete Attendee successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload("completed ")
                .build();
        return ResponseEntity.ok(attendeeResponse);
    }




}

