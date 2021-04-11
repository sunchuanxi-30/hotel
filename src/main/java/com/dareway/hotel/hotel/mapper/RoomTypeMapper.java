package com.dareway.hotel.hotel.mapper;

import com.dareway.hotel.hotel.model.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomTypeMapper {
    @Select("select * from roomtype where hotel_id = #{hotelId}")
    public List<RoomType> getHotelTypeByHotelId(@Param("hotelId") int hotelId);
}
