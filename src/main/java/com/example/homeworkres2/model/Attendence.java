package com.example.homeworkres2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendence {
    private int attendeeId;
    private String attendeeName;
    private String email;
}
