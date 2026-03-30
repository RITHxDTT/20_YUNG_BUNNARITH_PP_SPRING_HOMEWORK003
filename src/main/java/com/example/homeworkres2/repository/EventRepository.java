package com.example.homeworkres2.repository;

import com.example.homeworkres2.model.Events;
import com.example.homeworkres2.request.EventRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface EventRepository {
    @Results(id = "mapperEvent", value = {
            @Result(property = "eventId", column = "event_id"),

            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_date"),
            @Result(property = "veName", column = "venue_name"),
            @Result(property = "venLocation", column = "location"),
            @Result(property = "venuseSub", column =  "venue_id" , one = @One(select = "com.example.homeworkres2.repository.VenuesEventRepository.getVenuFromSub"))
    })
    @Select("select * from event limit #{size} offset (#{page} - 1) * #{size}")
    List<Events> getAllEvents(int size, int page);

    @ResultMap("mapperEvent")
    @Select("select * from event where event_id = #{id}")
    Events getById(int id);

    @ResultMap("mapperEvent")
    @Select("insert into event(event_name, event_date, venue_id) values(#{eventName}, #{eventDate}, #{venueId}) returning *")
    Events createEvent(EventRequest request);

    @ResultMap("mapperEvent")
    @Select("update event set event_name = #{res.eventName}, event_date = #{res.eventDate}, venue_id = #{res.venueId} where event_id = #{id} returning *")
    Events updateEvent(@Param("res") EventRequest request, int id);

    @Select("delete from event where event_id = #{id} returning *")
    String deleteEvent(int id);

    @Select("select * from event where event_name = #{eventName}")
    Events getEventByName(String eventName);

    @Select("select * from event where venue_id = #{id}")
    List<Events> getEventByVenueId(int id);

}
