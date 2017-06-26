package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"hotelCode","otaHotelId"})
public class TCSL_PARAM_AddOrder_BasicPropertyInfo {
    private String hotelCode;
    private String otaHotelId;

    public TCSL_PARAM_AddOrder_BasicPropertyInfo() {
    }

    public TCSL_PARAM_AddOrder_BasicPropertyInfo(String hotelCode, String otaHotelId) {
        this.hotelCode = hotelCode;
        this.otaHotelId = otaHotelId;
    }
    @XmlAttribute(name = "HotelCode")
    public String getHotelCode() {
        return this.hotelCode;
    }
    @XmlAttribute(name = "OtaHotelId")
    public String getOtaHotelId() {
        return this.otaHotelId;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public void setOtaHotelId(String otaHotelId) {
        this.otaHotelId = otaHotelId;
    }
}
