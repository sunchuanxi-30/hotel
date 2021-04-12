package com.dareway.hotel.hotel.controller;


import com.dareway.hotel.hotel.annotation.UserLoginToken;
import com.dareway.hotel.hotel.model.Hotel;
import com.dareway.hotel.hotel.model.User;
import com.dareway.hotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @UserLoginToken
    @PostMapping("/getAllHotel")
    public Map<String,Object> getAllHotel(@RequestBody Hotel para){
        Map<String,Object> map=new HashMap<String,Object>();
        String hotelName = para.getHotelName();
        int currentPage = para.getCurrentPage();
        int pageSize = para.getPageSize();
        List<Hotel> allHotel;
        if (hotelName.equals("")) {
            allHotel = hotelService.getAllHotel();
        }else {
            allHotel = hotelService.getHotelByName(hotelName);
        }
        if (pageSize*(currentPage - 1)+pageSize<=allHotel.size()){
            map.put("data",allHotel.subList(pageSize*(currentPage - 1),pageSize*(currentPage - 1)+pageSize));
        }else {
            map.put("data",allHotel.subList(pageSize*(currentPage - 1),allHotel.size()));
        }
        map.put("totalCount",allHotel.size());
        return map;
    }
}
