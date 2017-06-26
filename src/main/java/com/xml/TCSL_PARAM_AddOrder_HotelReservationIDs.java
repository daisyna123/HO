package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */

public class TCSL_PARAM_AddOrder_HotelReservationIDs {
    private TCSL_PARAM_AddOrder_HotelReservationID  hotelReservationID;

    public TCSL_PARAM_AddOrder_HotelReservationIDs() {
    }

    public TCSL_PARAM_AddOrder_HotelReservationIDs(TCSL_PARAM_AddOrder_HotelReservationID hotelReservationID) {
        this.hotelReservationID = hotelReservationID;
    }
    @XmlElement(name = "HotelReservationID")
    public TCSL_PARAM_AddOrder_HotelReservationID getHotelReservationID() {
        return hotelReservationID;
    }

    public void setHotelReservationID(TCSL_PARAM_AddOrder_HotelReservationID hotelReservationID) {
        this.hotelReservationID = hotelReservationID;
    }
}
