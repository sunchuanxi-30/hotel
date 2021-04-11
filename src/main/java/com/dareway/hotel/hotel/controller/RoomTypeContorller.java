package com.dareway.hotel.hotel.controller;


import com.dareway.hotel.hotel.model.RoomType;
import com.dareway.hotel.hotel.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hotelType")
public class RoomTypeContorller {
    @Autowired
    private RoomTypeService roomTypeService;

    @PostMapping("/getHotelTypeByHotelId")
    public Map<String,Object> getHotelTypeByHotelId(@RequestBody RoomType para){
        Map<String,Object> map=new HashMap<String,Object>();
        int hotelId = para.getHotelId();
        List<RoomType> allHotelType = roomTypeService.getHotelTypeByHotelId(hotelId);
        map.put("data",allHotelType);
        return map;
    }
}
