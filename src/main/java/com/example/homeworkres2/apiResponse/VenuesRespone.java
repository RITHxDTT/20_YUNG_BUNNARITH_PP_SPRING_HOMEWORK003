package com.example.homeworkres2.apiResponse;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class VenuesRespone <T>{
    private T payload;
    private String status;
    private String message;
    private LocalDate timestamp;

}
