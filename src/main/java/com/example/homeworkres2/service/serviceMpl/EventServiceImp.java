package com.example.homeworkres2.service.serviceMpl;

import com.example.homeworkres2.exception.DuplicateEmailException;
import com.example.homeworkres2.exception.GreaterException;
import com.example.homeworkres2.exception.NotFoundExceptionHandler;
import com.example.homeworkres2.model.Events;
//import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.repository.EventRepository;
//import com.example.homeworkres2.repository.eventRepository;
import com.example.homeworkres2.request.EventRequest;
import com.example.homeworkres2.request.VenuesRequest;
import com.example.homeworkres2.service.EventService;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
//@RequiredArgsConstructor
public class EventServiceImp implements EventService {
    private final EventRepository eventRepository;

    @Override
    public List<Events> getAllEvent(int size, int page) {
        if(size < 0 || page <0){
            throw new  GreaterException("number can't be negative !, must greater than 0 ");
        }
        return eventRepository.getAllEvents(size, page);
    }

    @Override
    public Events getById(int id) {
        Events eventById = eventRepository.getById(id);

        if(id < 0){
            throw new  GreaterException("number can't be negative !, must greater than 0 ");
        }
        else if(eventById == null){
            throw new NotFoundExceptionHandler("Event with this Id " + id + " not found");
        }
        return eventRepository.getById(id);
    }

    @Override
    public Events updateEvent(EventRequest request, int id) {
        Events eventsID = eventRepository.getById(id);
        if(id < 0){
            throw new  GreaterException("number can't be negative !, must greater than 0 ");
        }
       else if(eventsID == null){
            throw new NotFoundExceptionHandler("Can't update with this ID: " + id + " , ID not found");
       }

       if(eventRepository.getEventByName(request.getEventName())!= null){
           throw new DuplicateEmailException("can't update with this event name, exist ! ");
       }
       else if(eventRepository.getEventByVenueId(id) == null){
           throw new NotFoundExceptionHandler("Venue  ID not found  ");
       }
        return eventRepository.updateEvent(request, id);
    }

    @Override
    public Events createEvent(EventRequest request) {
        if(eventRepository.getEventByName(request.getEventName()) != null){
            throw new DuplicateEmailException("can't create with this event name, exist ! ");
        }
        else if(eventRepository.getEventByVenueId(request.getVenueId()) == null){
            throw new NotFoundExceptionHandler("Venue  ID not found  ");
        }
        return eventRepository.createEvent(request);
    }


    @Override
    public void deleteEvent(int id) {
        Events venuseId = eventRepository.getById(id);
        if(venuseId == null){
            throw new NotFoundExceptionHandler("Can't Delete with this ID: " + id + " , ID not found");
        }
        eventRepository.deleteEvent(id);
    }
}
