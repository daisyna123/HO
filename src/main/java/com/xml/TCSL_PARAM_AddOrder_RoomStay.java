package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"roomRates","guestCounts","timeSpan","guarantee","total","basicPropertyInfo","specialRequests"})
public class TCSL_PARAM_AddOrder_RoomStay {
    private TCSL_PARAM_AddOrder_RoomRates roomRates;
    private TCSL_PARAM_AddOrder_GuestCounts guestCounts;
    private TCSL_PARAM_AddOrder_TimeSpan timeSpan;
    private TCSL_PARAM_AddOrder_Guarantee guarantee;
    private TCSL_PARAM_AddOrder_Total total;
    private TCSL_PARAM_AddOrder_BasicPropertyInfo basicPropertyInfo;
    private TCSL_PARAM_AddOrder_SpecialRequests specialRequests;

    public TCSL_PARAM_AddOrder_RoomStay() {
    }

    public TCSL_PARAM_AddOrder_RoomStay(TCSL_PARAM_AddOrder_RoomRates roomRates, TCSL_PARAM_AddOrder_GuestCounts guestCounts, TCSL_PARAM_AddOrder_TimeSpan timeSpan, TCSL_PARAM_AddOrder_Guarantee guarantee, TCSL_PARAM_AddOrder_Total total, TCSL_PARAM_AddOrder_BasicPropertyInfo basicPropertyInfo, TCSL_PARAM_AddOrder_SpecialRequests specialRequests) {
        this.roomRates = roomRates;
        this.guestCounts = this.guestCounts;
        this.timeSpan = timeSpan;
        this.guarantee = guarantee;
        this.total = total;
        this.basicPropertyInfo = basicPropertyInfo;
        this.specialRequests = specialRequests;
    }
    @XmlElement(name = "RoomRates")
    public TCSL_PARAM_AddOrder_RoomRates getRoomRates() {
        return roomRates;
    }

    public void setRoomRates(TCSL_PARAM_AddOrder_RoomRates roomRates) {
        this.roomRates = roomRates;
    }
    @XmlElement(name = "GuestCounts")
    public TCSL_PARAM_AddOrder_GuestCounts getGuestCounts() {
        return this.guestCounts;
    }

    public void setGuestCounts(TCSL_PARAM_AddOrder_GuestCounts guestCounts) {
        this.guestCounts = guestCounts;
    }
    @XmlElement(name = "TimeSpan")
    public TCSL_PARAM_AddOrder_TimeSpan getTimeSpan() {
        return this.timeSpan;
    }

    public void setTimeSpan(TCSL_PARAM_AddOrder_TimeSpan timeSpan) {
        this.timeSpan = timeSpan;
    }
    @XmlElement(name = "Guarantee")
    public TCSL_PARAM_AddOrder_Guarantee getGuarantee() {
        return guarantee;
    }

    public void setGuarantee(TCSL_PARAM_AddOrder_Guarantee guarantee) {
        this.guarantee = guarantee;
    }
    @XmlElement(name = "Total")
    public TCSL_PARAM_AddOrder_Total getTotal() {
        return total;
    }

    public void setTotal(TCSL_PARAM_AddOrder_Total total) {
        this.total = total;
    }
    @XmlElement(name = "BasicPropertyInfo")
    public TCSL_PARAM_AddOrder_BasicPropertyInfo getBasicPropertyInfo() {
        return this.basicPropertyInfo;
    }

    public void setBasicPropertyInfo(TCSL_PARAM_AddOrder_BasicPropertyInfo basicPropertyInfo) {
        this.basicPropertyInfo = basicPropertyInfo;
    }
    @XmlElement(name = "SpecialRequests")
    public TCSL_PARAM_AddOrder_SpecialRequests getSpecialRequests() {
        return this.specialRequests;
    }

    public void setSpecialRequests(TCSL_PARAM_AddOrder_SpecialRequests specialRequests) {
        this.specialRequests = specialRequests;
    }
}
