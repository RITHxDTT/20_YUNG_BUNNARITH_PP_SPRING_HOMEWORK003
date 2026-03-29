package com.example.homeworkres2.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenuesRequest {
    @NotBlank(message = "user cant blank ")
    private String venName;
    private String location;
}
