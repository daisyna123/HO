package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"hotelReservationIDs","interFaceSendID","orderType","isFlashLive","depositAmount"})
public class TCSL_PARAM_AddOrder_ResGlobalInfo {
   private TCSL_PARAM_AddOrder_HotelReservationIDs hotelReservationIDs;
   private String interFaceSendID;
   private String orderType;
   private String isFlashLive;
   private String depositAmount;

    public TCSL_PARAM_AddOrder_ResGlobalInfo() {
    }

    public TCSL_PARAM_AddOrder_ResGlobalInfo(TCSL_PARAM_AddOrder_HotelReservationIDs hotelReservationIDs, String interFaceSendID, String orderType, String isFlashLive, String depositAmount) {
        this.hotelReservationIDs = hotelReservationIDs;
        this.interFaceSendID = interFaceSendID;
        this.orderType = orderType;
        this.isFlashLive = isFlashLive;
        this.depositAmount = depositAmount;
    }
    @XmlElement(name = "HotelReservationIDs")
    public TCSL_PARAM_AddOrder_HotelReservationIDs getHotelReservationIDs() {
        return hotelReservationIDs;
    }

    public void setHotelReservationIDs(TCSL_PARAM_AddOrder_HotelReservationIDs hotelReservationIDs) {
        this.hotelReservationIDs = hotelReservationIDs;
    }
    @XmlElement(name = "InterFaceSendID")
    public String getInterFaceSendID() {
        return interFaceSendID;
    }

    public void setInterFaceSendID(String interFaceSendID) {
        this.interFaceSendID = interFaceSendID;
    }
    @XmlElement(name = "OrderType")
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
    @XmlElement(name = "IsFlashLive")
    public String getIsFlashLive() {
        return isFlashLive;
    }

    public void setIsFlashLive(String isFlashLive) {
        this.isFlashLive = isFlashLive;
    }
    @XmlElement(name = "DepositAmount")
    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }
}
