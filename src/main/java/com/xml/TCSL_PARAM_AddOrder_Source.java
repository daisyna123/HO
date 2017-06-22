package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_Source {
    private TCSL_PARAM_AddOrder_RequestorID requestorID;

    public TCSL_PARAM_AddOrder_Source() {
    }

    public TCSL_PARAM_AddOrder_Source(TCSL_PARAM_AddOrder_RequestorID requestorID) {
        requestorID = requestorID;
    }
    @XmlElement(name = "RequestorID")
    public TCSL_PARAM_AddOrder_RequestorID getRequestorID() {
        return requestorID;
    }

    public void setRequestorID(TCSL_PARAM_AddOrder_RequestorID requestorID) {
        requestorID = requestorID;
    }
}
