package com.example.homeworkres2.service;


import com.example.homeworkres2.model.Attendence;
import com.example.homeworkres2.model.Events;
import com.example.homeworkres2.request.AttendeeRequest;
import com.example.homeworkres2.request.EventRequest;

import java.util.List;

public interface AttendeeService {
    public List<Attendence> getAllAttendee(int size, int page);
    public Attendence getById(int id);
    public Attendence updateAttendee(AttendeeRequest request, int id);
    public Attendence createAttendee (AttendeeRequest request);
    public void deleteAttendee(int id);
}
