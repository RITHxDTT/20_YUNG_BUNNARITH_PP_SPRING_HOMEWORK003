package com.example.homeworkres2.controller;


import com.example.homeworkres2.apiResponse.VenuesRespone;
import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.request.VenuesRequest;
import com.example.homeworkres2.service.VenuesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class venuesController {
    private final VenuesService venuesService;


    @GetMapping
    public ResponseEntity<VenuesRespone> getAllVenues(@RequestParam int size, @RequestParam int page){
        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.getAllVenuse(size,page))
                .build();

        return ResponseEntity.ok(venuesRespone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenuesRespone> getByIdVenues(@PathVariable  int id){
        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Retrieved venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.getById(id)).build();
        return ResponseEntity.ok(venuesRespone);
    }

    @PostMapping
    public ResponseEntity<VenuesRespone> createVenu(@RequestBody VenuesRequest request){

        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("created venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.createVenues(request)).build();
        return ResponseEntity.ok(venuesRespone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VenuesRespone> updateVenu(@RequestBody VenuesRequest request, @PathVariable int id){

        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Update venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
                .payload(venuesService.updateVenues(request, id)).build();
        return ResponseEntity.ok(venuesRespone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VenuesRespone> deleteVenu(@PathVariable int id){
        venuesService.deleteVenues(id);
        VenuesRespone venuesRespone = VenuesRespone.builder()
                .message("Delete venues successfully")
                .status("ok")
                .timestamp(LocalDate.now())
             .build();
        return ResponseEntity.ok(venuesRespone);
    }


}
