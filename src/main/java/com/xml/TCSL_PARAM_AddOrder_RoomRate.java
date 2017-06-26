package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"roomTypeCode","numberOfUnits","ratePlanCode","ratePlanCategory","otaSubRoomTypeName"})
public class TCSL_PARAM_AddOrder_RoomRate {
    private String roomTypeCode;
    private String numberOfUnits;
    private String ratePlanCode;
    private String ratePlanCategory;
    private String otaSubRoomTypeName;

    public TCSL_PARAM_AddOrder_RoomRate() {
    }

    public TCSL_PARAM_AddOrder_RoomRate(String roomTypeCode, String numberOfUnits, String ratePlanCode, String ratePlanCategory, String otaSubRoomTypeName) {
        this.roomTypeCode = roomTypeCode;
        this.numberOfUnits = numberOfUnits;
        this.ratePlanCode = ratePlanCode;
        this.ratePlanCategory = ratePlanCategory;
        this.otaSubRoomTypeName = otaSubRoomTypeName;
    }

    @XmlAttribute(name = "RoomTypeCode")
    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }
    @XmlAttribute(name = "NumberOfUnits")
    public String getNumberOfUnits() {
        return numberOfUnits;
    }

    public void setNumberOfUnits(String numberOfUnits) {
        this.numberOfUnits = numberOfUnits;
    }
    @XmlAttribute(name = "RatePlanCode")
    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }
    @XmlAttribute(name = "RatePlanCategory")
    public String getRatePlanCategory() {
        return ratePlanCategory;
    }

    public void setRatePlanCategory(String ratePlanCategory) {
        this.ratePlanCategory = ratePlanCategory;
    }
    @XmlAttribute(name = "OtaSubRoomTypeName")
    public String getOtaSubRoomTypeName() {
        return otaSubRoomTypeName;
    }

    public void setOtaSubRoomTypeName(String otaSubRoomTypeName) {
        this.otaSubRoomTypeName = otaSubRoomTypeName;
    }
}
