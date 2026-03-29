package com.example.homeworkres2.service.serviceMpl;

import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.model.Attendence;
import com.example.homeworkres2.model.Events;
import com.example.homeworkres2.repository.AttendeeRepository;
import com.example.homeworkres2.repository.EventRepository;
import com.example.homeworkres2.request.AttendeeRequest;
import com.example.homeworkres2.request.EventRequest;
import com.example.homeworkres2.service.AttendeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class AttendeeServiceImp implements AttendeeService {
    private final AttendeeRepository attendeeRepository;

    @Override
    public List<Attendence> getAllAttendee(int size, int page) {

        return attendeeRepository.getAllAttendees(size, page);
    }

    @Override
    public Attendence getById(int id) {
        Attendence attendeenById = attendeeRepository.getById(id);
        if(attendeenById == null){
            throw new NotFoundExceptionHandler("Attendee with this Id " + id + " not found");
        }
        return attendeeRepository.getById(id);
    }

    @Override
    public Attendence updateAttendee(AttendeeRequest request, int id) {
        Attendence attendence = attendeeRepository.getById(id);
        if(attendence == null){
            throw new NotFoundExceptionHandler("Can't update with this ID: " + id + " , ID not found");
        }
        return attendeeRepository.updateAttendee(request, id);
    }

    @Override
    public Attendence createAttendee(AttendeeRequest request) {

        return attendeeRepository.createAttendee(request);
    }


    @Override
    public void deleteAttendee(int id) {
        Attendence attendenceById = attendeeRepository.getById(id);
        if(attendenceById == null){
            throw new NotFoundExceptionHandler("Can't Delete with this ID: " + id + " , ID not found");
        }
        attendeeRepository.deleteAttendee(id);
    }
}
