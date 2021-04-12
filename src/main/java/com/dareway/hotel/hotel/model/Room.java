package com.dareway.hotel.hotel.model;

import lombok.Data;

import java.io.Serializable;
@Data
public class Room implements Serializable {
    private int room_id;
    private String room_name;
    private String room_price;
    private int room_count;
    private String room_type;
    private String room_city;
}
