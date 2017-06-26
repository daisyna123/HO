package com.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_RequestorID {
    private String ID;

    public TCSL_PARAM_AddOrder_RequestorID(String ID) {
        this.ID = ID;
    }

    public TCSL_PARAM_AddOrder_RequestorID() {
    }
    @XmlAttribute(name = "ID")
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
