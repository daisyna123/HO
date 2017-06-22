package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_GuestCounts {
    private TCSL_PARAM_AddOrder_GuestCount guestCount;

    public TCSL_PARAM_AddOrder_GuestCounts() {
    }

    public TCSL_PARAM_AddOrder_GuestCounts(TCSL_PARAM_AddOrder_GuestCount guestCount) {
        this.guestCount = guestCount;
    }
    @XmlElement(name = "GuestCount")
    public TCSL_PARAM_AddOrder_GuestCount getGuestCount() {
        return guestCount;
    }

    public void setGuestCount(TCSL_PARAM_AddOrder_GuestCount guestCount) {
        this.guestCount = guestCount;
    }
}
