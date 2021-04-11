package com.dareway.hotel.hotel.service.impl;

import com.dareway.hotel.hotel.mapper.HotelMapper;
import com.dareway.hotel.hotel.model.Hotel;
import com.dareway.hotel.hotel.service.HotelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {
    @Resource
    private HotelMapper hotelMapper;
    @Override
    public List<Hotel> getAllHotel() {
        return hotelMapper.getAllHotel();
    }

    @Override
    public List<Hotel> getHotelByName(String hotelName) {
        return hotelMapper.getHotelByName(hotelName);
    }
}
