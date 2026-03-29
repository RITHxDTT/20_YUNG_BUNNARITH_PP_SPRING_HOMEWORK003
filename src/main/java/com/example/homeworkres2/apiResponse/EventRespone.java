package com.example.homeworkres2.apiResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRespone<T> {
    private T payload;
    private String status;
    private String message;
    private LocalDate timestamp;
}
