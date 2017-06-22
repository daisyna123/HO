package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_SpecialRequests {
    private TCSL_PARAM_AddOrder_SpecialRequest specialRequest;

    public TCSL_PARAM_AddOrder_SpecialRequests() {
    }

    public TCSL_PARAM_AddOrder_SpecialRequests(TCSL_PARAM_AddOrder_SpecialRequest specialRequest) {
        this.specialRequest = specialRequest;
    }
    @XmlElement(name = "SpecialRequest")
    public TCSL_PARAM_AddOrder_SpecialRequest getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(TCSL_PARAM_AddOrder_SpecialRequest specialRequest) {
        this.specialRequest = specialRequest;
    }
}
