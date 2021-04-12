package com.dareway.hotel.hotel.mapper;

import com.dareway.hotel.hotel.model.RoomType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomTypeMapper {
    @Select("select * from roomtype where hotel_id = #{hotelId}")
    public List<RoomType> getHotelTypeByHotelId(@Param("hotelId") int hotelId);

    @Insert(" insert into room_type set (room_type_name,room_type_price,room_type_service,room_type_service,hotel_id) values(roomType.roomTypeName,roomType.roomTypePrice,roomTypeService,roomType.hotelId)")
    public int addRoomType(@Param("roomType") RoomType roomType);
}
