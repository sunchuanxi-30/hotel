package com.dareway.hotel.hotel.controller;


import com.dareway.hotel.hotel.model.Po.RoomTypePo;
import com.dareway.hotel.hotel.model.RoomType;
import com.dareway.hotel.hotel.service.RoomTypeService;
import org.springframework.beans.BeanUtils;
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

    @PostMapping("/addRoomType")
    public Map<String,Object> addRoomType(@RequestBody RoomTypePo roomTypePo){
        //前端传过来一个PO对象 其中service 是一个int类型的数组 如[1,2,3]
        Map<String,Object> map=new HashMap<String,Object>();
        List<Integer> roomTypeServiceList = roomTypePo.getRoomTypeService();
        String roomTypeServiceStr = "";
        for (Integer integer : roomTypeServiceList) {
            //拼完之后是 "123" 我没给你加 ,
            roomTypeServiceStr += integer;
        }
        RoomType roomType = new RoomType();
        //将PO中和Model 中相同的属性copy过去
        BeanUtils.copyProperties(roomTypePo,roomType);
        roomType.setRoomTypeService(roomTypeServiceStr);
        int i = roomTypeService.addRoomType(roomType);
        if(i>0){
            map.put("code","001");
            map.put("msg","添加成功");
            return map;
        }
        map.put("code","002");
        map.put("msg","添加失败");
        return map;
    }
}
