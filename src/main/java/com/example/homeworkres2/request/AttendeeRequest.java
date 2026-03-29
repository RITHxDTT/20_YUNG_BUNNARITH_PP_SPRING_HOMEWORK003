package com.example.homeworkres2.request;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendeeRequest {
    private String attendeeName;
    @Email(message = "Invalid email please try again")
    private String email;
}
