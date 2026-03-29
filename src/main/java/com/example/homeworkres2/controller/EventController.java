package com.example.homeworkres2.controller;

import com.example.homeworkres2.apiResponse.EventRespone;
import com.example.homeworkres2.apiResponse.VenuesRespone;
import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.repository.EventRepository;
import com.example.homeworkres2.request.EventRequest;
import com.example.homeworkres2.request.VenuesRequest;
import com.example.homeworkres2.service.EventService;
import com.example.homeworkres2.service.VenuesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor

public class EventController {
    private final EventRepository eventRepository;
    private final EventService eventService;


    @GetMapping
    public ResponseEntity<EventRespone> getAllVenues(@RequestParam int size, @RequestParam int page){
        EventRespone eventRespone = EventRespone.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(eventService.getAllEvent(size,page))
                .build();

        return ResponseEntity.ok(eventRespone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventRespone> getByIdEvent(@PathVariable int id){
        EventRespone eventRespone = EventRespone.builder()
                .message("Retrieved Event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(eventService.getById(id)).build();
        return ResponseEntity.ok(eventRespone);
    }

    @PostMapping
    public ResponseEntity<EventRespone> createEvent(@RequestBody @Valid EventRequest request){

        EventRespone eventRespone = EventRespone.builder()
                .message("created event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(eventService.createEvent(request)).build();
        return ResponseEntity.ok(eventRespone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventRespone> updateEvent(@RequestBody EventRequest request, @PathVariable int id){

        EventRespone eventRespone = EventRespone.builder()
                .message("Update event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(eventService.updateEvent(request, id)).build();
        return ResponseEntity.ok(eventRespone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EventRespone> deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
        EventRespone eventRespone = EventRespone.builder()
                .message("Delete event successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .build();
        return ResponseEntity.ok(eventRespone);
    }




//    public ResponseEntity<?> handlerExceptioon(NotFoundExceptionHandler ex){
//        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(
//                ApiRespone.<VenuesRespone>builder()
//                        .title("Not found")
//                        .timestamp(LocalDate.now())
//                        .message(ex.getMessage())
//                        .payload(null)
//                        .build()
//        );
//    }
@ExceptionHandler(NotFoundExceptionHandler.class)
    public ProblemDetail handlerExceptioon(NotFoundExceptionHandler ex){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        problemDetail.setProperty("timestamp" , Instant.now());
        return  problemDetail;
    }
}
