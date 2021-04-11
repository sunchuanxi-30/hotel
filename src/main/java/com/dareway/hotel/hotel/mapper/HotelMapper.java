package com.dareway.hotel.hotel.mapper;

import com.dareway.hotel.hotel.model.Hotel;
import com.dareway.hotel.hotel.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelMapper {
    @Select("select * from hotel")
    public List<Hotel> getAllHotel();
    @Select("select * from hotel where hotel_name like  CONCAT('%',#{hotelName},'%')")
    public List<Hotel> getHotelByName(@Param("hotelName") String hotelName);
}
