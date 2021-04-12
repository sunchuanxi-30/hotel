package com.dareway.hotel.hotel.pojo;

public enum HotelTypeEnum {
    HOUR_ROOM(1,  "hour room"),
    DAY_ROOM(2,  "day room"),
    ECONOMY_ROOM (3,  "economy room");


    private int code;
    private String type;

    public int getCode(){
        return this.code;
    }

    public String getType(){
        return this.type;
    }

    HotelTypeEnum(int code, String type){
        this.code = code;
        this.type = type;
    }

    public static HotelTypeEnum codeOf(int code){
        for(HotelTypeEnum hotelTypeEnum : values()){
            if(hotelTypeEnum.getCode() == code){
                return hotelTypeEnum;
            }
        }
        throw new RuntimeException("No corresponding enumeration was found");
    }
}
