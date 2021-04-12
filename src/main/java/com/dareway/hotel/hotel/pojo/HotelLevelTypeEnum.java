package com.dareway.hotel.hotel.pojo;

public enum HotelLevelTypeEnum {
    LEVEL_STAR_ONE(1,  "One Star"),
    LEVEL_STAR_TWO(2,  "Two Star"),
    LEVEL_STAR_THREE (3,  "Three Star"),
    LEVEL_STAR_FOUR(4,  "Four Star"),
    LEVEL_STAR_FIVE(5,  "Five Star");


    private int code;
    private String type;

    public int getCode(){
        return this.code;
    }

    public String getType(){
        return this.type;
    }

    HotelLevelTypeEnum(int code, String type){
        this.code = code;
        this.type = type;
    }

    public static HotelLevelTypeEnum codeOf(int code){
        for(HotelLevelTypeEnum hotelLevelTypeEnum : values()){
            if(hotelLevelTypeEnum.getCode() == code){
                return hotelLevelTypeEnum;
            }
        }
        throw new RuntimeException("No corresponding enumeration was found");
    }
}
