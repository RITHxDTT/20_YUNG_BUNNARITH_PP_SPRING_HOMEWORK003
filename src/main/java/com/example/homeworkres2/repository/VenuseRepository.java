package com.example.homeworkres2.repository;

import com.example.homeworkres2.model.Venuse;
import com.example.homeworkres2.request.VenuesRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VenuseRepository {

    @Results(id = "mapperVenuse", value = {
            @Result(property = "veName", column = "venue_name"),
            @Result(property = "venLocation", column = "location")
    })
    @Select("select * from venues limit  #{size} offset  (#{page} -1) * #{size}")
     List<Venuse> getAllVenuse(int size, int page);

    @ResultMap("mapperVenuse")
    @Select("select * from venues where id = #{id}")
    Venuse getById(int id);

    @ResultMap("mapperVenuse")
    @Select("insert into venues(venue_name, location) values(#{venName}, #{location}) returning *")
    Venuse createVenu(VenuesRequest request);

    @ResultMap("mapperVenuse")
    @Select("update  venues set venue_name = #{res.venName}, location = #{res.location} where id = #{id} returning *")
    Venuse updateVenu(@Param("res") VenuesRequest request, int id );

    @ResultMap("mapperVenuse")
    @Select("delete from venues where id = #{id}")
    String deleteVenue(int id);
}
