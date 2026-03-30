package com.example.homeworkres2.repository;


import com.example.homeworkres2.model.Attendence;
import com.example.homeworkres2.request.AttendeeRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AttendeeRepository {

    @Results(id = "mapperAttendee", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
            @Result(property = "email", column = "email")
    })
    @Select("select * from attendees limit #{size} offset (#{page} - 1) * #{size}")
    List<Attendence> getAllAttendees(int size, int page);

    @ResultMap("mapperAttendee")
    @Select("select * from attendees where attendee_id = #{id}")
    Attendence getById(int id);

    @ResultMap("mapperAttendee")
    @Select("insert into attendees(attendee_name, email) values(#{attendeeName}, #{email}) returning *")
    Attendence createAttendee(AttendeeRequest request);

    @ResultMap("mapperAttendee")
    @Select("update attendees set attendee_name = #{res.attendeeName}, email = #{res.email} where attendee_id = #{id} returning *")
    Attendence updateAttendee(@Param("res") AttendeeRequest request, int id);

    @Select("delete from attendees where attendee_id = #{id} returning * ")
    String deleteAttendee(int id);


    @Select("select * from attendees where email = #{email}")
    Attendence getEmail(String email);

    @Select("select * from attendees where attendee_name = #{attendeeName}")
    Attendence getName(String attendeeName);
}