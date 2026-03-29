package com.example.homeworkres2.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventRequest {
    @NotBlank(message = "event name  can not blank ")
    private String eventName;
    private LocalDate eventDate;
    private int venueId;
}
