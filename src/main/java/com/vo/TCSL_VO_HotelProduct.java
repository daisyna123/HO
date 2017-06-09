package com.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @DESCRIPTION 酒店产品信息
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_VO_HotelProduct {
    //房型代码
    private String roomTypeCode;
    //房型名称
    private String roomTypeName;
    //价格代码名称
    private String ratePlanCode;
    /*
     * 现预付类型
     * 501-预付
     * 16-现付
     */
    private String balanceType;
    //价格代码名称
    private String ratePlanName;
    /*
     * 渠道
     * 如：CTRIP,QUNAR,ELONG
     */
    private String channel;

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(String roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }
}
