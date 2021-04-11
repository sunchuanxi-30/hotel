package com.dareway.hotel.hotel.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class RoomType implements Serializable {
    private int roomTypeId;
    private String roomTypeName;
    private Double roomTypePrice;
    private String roomTypeService;
    private int hotelId;
}
