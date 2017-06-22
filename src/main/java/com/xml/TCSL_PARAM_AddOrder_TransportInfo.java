package com.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_TransportInfo {
    private String time;

    public TCSL_PARAM_AddOrder_TransportInfo() {
    }

    public TCSL_PARAM_AddOrder_TransportInfo(String time) {
        this.time = time;
    }
    @XmlAttribute(name = "Time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
