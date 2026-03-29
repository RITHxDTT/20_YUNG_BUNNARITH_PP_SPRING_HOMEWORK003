//package com.example.homeworkres2.repository;
//
//import org.apache.ibatis.annotations.*;
//
//import java.util.List;
//
//@Mapper
//public interface EventAttendeeRepository {
//
//    @Insert("insert into event_attendee(attendee_id, event_id) values(#{attendeeId}, #{eventId})")
//    void addAttendeeToEvent(@Param("attendeeId") int attendeeId, @Param("eventId") int eventId);
//
//    @Delete("delete from event_attendee where attendee_id = #{attendeeId} and event_id = #{eventId}")
//    void removeAttendeeFromEvent(@Param("attendeeId") int attendeeId, @Param("eventId") int eventId);
//
//    @Select("select attendee_id from event_attendee where event_id = #{eventId}")
//    List<Integer> getAttendeesByEventId(int eventId);
//
//    @Select("select event_id from event_attendee where attendee_id = #{attendeeId}")
//    List<Integer> getEventsByAttendeeId(int attendeeId);
//}