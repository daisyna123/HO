package com.xml;/**
 * Created by administrator on 2017-06-02.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-06-02
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { })
public class PMSHotelMappingResult {
    @XmlElement(name="Channel")
    private String channel;
    @XmlElement(name="HotelCode")
    private String hotelCode;
    @XmlElement(name="RoomTypeCode")
    private String roomTypeCode;
    @XmlElement(name="RatePlanCode")
    private String ratePlanCode;
    @XmlElement(name="IsSuccess")
    private String isSuccess;
    @XmlElement(name="ErrorCode")
    private String errorCode;
    @XmlElement(name="Message")
    private String message;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(String isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
