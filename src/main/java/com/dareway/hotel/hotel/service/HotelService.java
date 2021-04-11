package com.dareway.hotel.hotel.service;

import com.dareway.hotel.hotel.model.Hotel;

import java.util.List;

public interface HotelService {
    List<Hotel> getAllHotel();
    List<Hotel> getHotelByName(String hotelName);

}
