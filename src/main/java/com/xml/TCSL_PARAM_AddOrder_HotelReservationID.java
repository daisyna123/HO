package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"resIdType","resIdValue"})
public class TCSL_PARAM_AddOrder_HotelReservationID {
    private String resIdType;
    private String resIdValue;

    public TCSL_PARAM_AddOrder_HotelReservationID() {
    }

    public TCSL_PARAM_AddOrder_HotelReservationID(String resIdType, String resIdValue) {
        this.resIdType = resIdType;
        this.resIdValue = resIdValue;
    }

    @XmlAttribute(name = "ResID_Type")
    public String getResIdType() {
        return resIdType;
    }

    public void setResIdType(String resIdType) {
        this.resIdType = resIdType;
    }
    @XmlAttribute(name = "ResID_Value")
    public String getResIdValue() {
        return resIdValue;
    }

    public void setResIdValue(String resIdValue) {
        this.resIdValue = resIdValue;
    }
}
