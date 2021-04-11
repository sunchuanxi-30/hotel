package com.dareway.hotel.hotel.pojo;

public enum RoomTypeServiceEnum {
    WIFI(1,  "wifi"),
    PARK(2,  "park"),
    WATER_HEATER (3,  "Water Heater"),
    SOFA(4,  "sofa"),
    AIR_CONDITIONING(5,  "Air Conditioning");


    private int code;
    private String type;

    public int getCode(){
        return this.code;
    }

    public String getType(){
        return this.type;
    }

    RoomTypeServiceEnum(int code,String type){
        this.code = code;
        this.type = type;
    }

    public static RoomTypeServiceEnum codeOf(int code){
        for(RoomTypeServiceEnum roomTypeServiceEnum : values()){
            if(roomTypeServiceEnum.getCode() == code){
                return roomTypeServiceEnum;
            }
        }
        throw new RuntimeException("No corresponding enumeration was found");
    }
}
