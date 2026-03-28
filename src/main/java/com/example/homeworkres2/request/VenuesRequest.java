package com.example.homeworkres2.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenuesRequest {
    private String venName;
    private String location;
}
