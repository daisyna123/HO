package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_ArrivalTransport {
    private TCSL_PARAM_AddOrder_TransportInfo TransportInfo;

    public TCSL_PARAM_AddOrder_ArrivalTransport() {
    }

    public TCSL_PARAM_AddOrder_ArrivalTransport(TCSL_PARAM_AddOrder_TransportInfo transportInfo) {
        TransportInfo = transportInfo;
    }
    @XmlElement(name = "TransportInfo")
    public TCSL_PARAM_AddOrder_TransportInfo getTransportInfo() {
        return TransportInfo;
    }

    public void setTransportInfo(TCSL_PARAM_AddOrder_TransportInfo transportInfo) {
        TransportInfo = transportInfo;
    }
}
