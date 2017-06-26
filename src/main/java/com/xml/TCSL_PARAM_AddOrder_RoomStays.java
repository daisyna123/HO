package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_RoomStays {
    private TCSL_PARAM_AddOrder_RoomStay roomStay;

    public TCSL_PARAM_AddOrder_RoomStays(TCSL_PARAM_AddOrder_RoomStay roomStay) {
        this.roomStay = roomStay;
    }

    public TCSL_PARAM_AddOrder_RoomStays() {
    }
    @XmlElement(name = "RoomStay")
    public TCSL_PARAM_AddOrder_RoomStay getRoomStay() {
        return this.roomStay;
    }

    public void setRoomStay(TCSL_PARAM_AddOrder_RoomStay roomStay) {
        this.roomStay = roomStay;
    }
}
