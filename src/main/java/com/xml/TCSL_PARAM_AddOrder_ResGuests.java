package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_ResGuests {
    private TCSL_PARAM_AddOrder_ResGuest resGuest;

    public TCSL_PARAM_AddOrder_ResGuests() {
    }

    public TCSL_PARAM_AddOrder_ResGuests(TCSL_PARAM_AddOrder_ResGuest resGuest) {
        this.resGuest = resGuest;
    }
    @XmlElement(name = "ResGuest")
    public TCSL_PARAM_AddOrder_ResGuest getResGuest() {
        return resGuest;
    }

    public void setResGuest(TCSL_PARAM_AddOrder_ResGuest resGuest) {
        this.resGuest = resGuest;
    }
}
