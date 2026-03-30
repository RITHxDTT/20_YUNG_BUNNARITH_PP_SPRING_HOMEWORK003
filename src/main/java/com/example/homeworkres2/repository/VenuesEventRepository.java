package com.example.homeworkres2.repository;

import com.example.homeworkres2.model.Venuse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VenuesEventRepository {
    @Results(id = "mapperVenuse", value = {
            @Result(property = "veName", column = "venue_name"),
            @Result(property = "id", column = "venue_id"),
            @Result(property = "venLocation", column = "location")
    })
    @Select("select * from venues as v inner join event as e on v.venue_id = e.venue_id where v.venue_id = #{id}")
    public List<Venuse> getVenuFromSub(int id);

}
