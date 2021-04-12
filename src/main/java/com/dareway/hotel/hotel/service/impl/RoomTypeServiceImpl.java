package com.dareway.hotel.hotel.service.impl;

import com.dareway.hotel.hotel.mapper.RoomTypeMapper;
import com.dareway.hotel.hotel.model.RoomType;
import com.dareway.hotel.hotel.service.RoomTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {
    @Resource
    private RoomTypeMapper roomTypeMapper;

    @Override
    public List<RoomType> getHotelTypeByHotelId(Integer hotelId) {
        return roomTypeMapper.getHotelTypeByHotelId(hotelId);
    }

    @Override
    public int addRoomType(RoomType roomType) {
        return roomTypeMapper.addRoomType(roomType);
    }
}
