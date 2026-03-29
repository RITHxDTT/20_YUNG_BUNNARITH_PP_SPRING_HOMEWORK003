package com.example.homeworkres2.service;

import com.example.homeworkres2.model.Events;
import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.request.EventRequest;
import com.example.homeworkres2.request.VenuesRequest;

import java.util.List;

public interface EventService {
    public List<Events> getAllEvent(int size, int page);
    public Events getById(int id);
    public Events updateEvent(EventRequest request, int id);
    public Events createEvent (EventRequest request);
    public void deleteEvent(int id);
}
