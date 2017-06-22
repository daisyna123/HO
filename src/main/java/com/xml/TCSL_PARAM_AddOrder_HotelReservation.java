package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"roomStays","resGuests","resGlobalInfo"})
public class TCSL_PARAM_AddOrder_HotelReservation {
    private TCSL_PARAM_AddOrder_RoomStays roomStays;
    private TCSL_PARAM_AddOrder_ResGuests resGuests;
    private TCSL_PARAM_AddOrder_ResGlobalInfo resGlobalInfo;

    public TCSL_PARAM_AddOrder_HotelReservation(TCSL_PARAM_AddOrder_RoomStays roomStays, TCSL_PARAM_AddOrder_ResGuests resGuests, TCSL_PARAM_AddOrder_ResGlobalInfo resGlobalInfo) {
        this.roomStays = roomStays;
        this.resGuests = resGuests;
        this.resGlobalInfo = resGlobalInfo;
    }

    public TCSL_PARAM_AddOrder_HotelReservation() {
    }
    @XmlElement(name = "RoomStays")
    public TCSL_PARAM_AddOrder_RoomStays getRoomStays() {
        return this.roomStays;
    }

    public void setRoomStays(TCSL_PARAM_AddOrder_RoomStays roomStays) {
        this.roomStays = roomStays;
    }
    @XmlElement(name = "ResGuests")
    public TCSL_PARAM_AddOrder_ResGuests getResGuests() {
        return this.resGuests;
    }

    public void setResGuests(TCSL_PARAM_AddOrder_ResGuests resGuests) {
        this.resGuests = resGuests;
    }
    @XmlElement(name = "ResGlobalInfo")
    public TCSL_PARAM_AddOrder_ResGlobalInfo getResGlobalInfo() {
        return this.resGlobalInfo;
    }

    public void setResGlobalInfo(TCSL_PARAM_AddOrder_ResGlobalInfo resGlobalInfo) {
        this.resGlobalInfo = resGlobalInfo;
    }
}
