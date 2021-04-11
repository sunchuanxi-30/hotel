package com.dareway.hotel.hotel.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Hotel implements Serializable {
    private int hotelId;
    private String hotelName;
    private String hotelTel;
    private String hotelCity;
    private String hotelAddress;
    private String hotelLevel;
    private String hotelType;
    private String hotelBrand;
    private String hotelService;


    private int pageSize;
    private int currentPage;
}
