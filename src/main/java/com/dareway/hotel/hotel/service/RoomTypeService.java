package com.dareway.hotel.hotel.service;

import com.dareway.hotel.hotel.model.RoomType;

import java.util.List;

public interface RoomTypeService {
    public List<RoomType> getHotelTypeByHotelId(Integer hotelId);
}
