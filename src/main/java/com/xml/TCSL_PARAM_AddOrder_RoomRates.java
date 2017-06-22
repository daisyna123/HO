package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"roomRate","rates"})
public class TCSL_PARAM_AddOrder_RoomRates {
    private TCSL_PARAM_AddOrder_RoomRate roomRate;
    private TCSL_PARAM_AddOrder_Rates rates;

    public TCSL_PARAM_AddOrder_RoomRates() {
    }

    public TCSL_PARAM_AddOrder_RoomRates(TCSL_PARAM_AddOrder_RoomRate roomRate, TCSL_PARAM_AddOrder_Rates rates) {
        this.roomRate = roomRate;
        this.rates = rates;
    }
    @XmlElement(name = "RoomRate")
    public TCSL_PARAM_AddOrder_RoomRate getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(TCSL_PARAM_AddOrder_RoomRate roomRate) {
        this.roomRate = roomRate;
    }
    @XmlElement(name = "Rates")
    public TCSL_PARAM_AddOrder_Rates getRates() {
        return rates;
    }

    public void setRates(TCSL_PARAM_AddOrder_Rates rates) {
        this.rates = rates;
    }
}
