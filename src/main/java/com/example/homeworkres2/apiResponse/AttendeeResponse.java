package com.example.homeworkres2.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendeeResponse<T> {
    private T payload;
    private String status;
    private String message;
    private LocalDate timestamp;
}
