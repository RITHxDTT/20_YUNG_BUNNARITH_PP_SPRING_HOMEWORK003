package com.example.homeworkres2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Venuse {
    private int id;
    private String veName;
    private String venLocation;

}
