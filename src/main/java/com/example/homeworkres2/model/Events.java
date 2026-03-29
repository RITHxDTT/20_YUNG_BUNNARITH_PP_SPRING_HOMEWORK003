package com.example.homeworkres2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Events {
    private String eventName;
    private LocalDate eventDate;
    private int eventId;
    private int venueId;
    private List<Venuse>  venuseSub;

}
