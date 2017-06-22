package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_HotelReservations {
    private TCSL_PARAM_AddOrder_HotelReservation hotelReservation;

    public TCSL_PARAM_AddOrder_HotelReservations() {
    }

    public TCSL_PARAM_AddOrder_HotelReservations(TCSL_PARAM_AddOrder_HotelReservation hotelReservation) {
        this.hotelReservation = hotelReservation;
    }
    @XmlElement(name = "HotelReservation")
    public TCSL_PARAM_AddOrder_HotelReservation getHotelReservation() {
        return this.hotelReservation;
    }

    public void setHotelReservation(TCSL_PARAM_AddOrder_HotelReservation hotelReservation) {
        this.hotelReservation = hotelReservation;
    }
}
