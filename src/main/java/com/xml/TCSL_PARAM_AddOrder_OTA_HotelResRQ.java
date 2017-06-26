package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 * 创建订单webservice传入参数映射类
 */
@XmlType(propOrder = {"pos","hotelReservations","resStatus","timeStamp","version"})
public class TCSL_PARAM_AddOrder_OTA_HotelResRQ {
    private TCSL_PARAM_AddOrder_POS pos;
    private TCSL_PARAM_AddOrder_HotelReservations hotelReservations;
    private String resStatus;
    private String timeStamp;
    private String version;

    public TCSL_PARAM_AddOrder_OTA_HotelResRQ(){ }

    public TCSL_PARAM_AddOrder_OTA_HotelResRQ(TCSL_PARAM_AddOrder_POS pos, TCSL_PARAM_AddOrder_HotelReservations hotelReservations, String resStatus, String timeStamp, String version) {
        this.pos = pos;
        this.hotelReservations = hotelReservations;
        this.resStatus = resStatus;
        this.timeStamp = timeStamp;
        this.version = version;
    }

    @XmlElement(name = "POS")
    public TCSL_PARAM_AddOrder_POS getPos() {
        return this.pos;
    }

    public void setPos(TCSL_PARAM_AddOrder_POS POS) {
        this.pos = POS;
    }

    @XmlElement(name = "HotelReservations")
    public TCSL_PARAM_AddOrder_HotelReservations getHotelReservations() {
        return this.hotelReservations;
    }

    public void setHotelReservations(TCSL_PARAM_AddOrder_HotelReservations hotelReservations) {
        this.hotelReservations = hotelReservations;
    }
    @XmlAttribute(name = "resStatus")
    public String getResStatus() {
        return resStatus;
    }
    @XmlAttribute(name = "TimeStamp")
    public String getTimeStamp() {
        return timeStamp;
    }
    @XmlAttribute(name = "Version")
    public String getVersion() {
        return version;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
