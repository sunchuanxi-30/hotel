package com.dareway.hotel.hotel.model.Po;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class RoomTypePo implements Serializable {
    private int roomTypeId;
    private String roomTypeName;
    private Double roomTypePrice;
    private List<Integer> roomTypeService;
    private int hotelId;
}
