package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"start","end"})
public class TCSL_PARAM_AddOrder_TimeSpan {
    private String start;
    private String end;

    public TCSL_PARAM_AddOrder_TimeSpan() {
    }

    public TCSL_PARAM_AddOrder_TimeSpan(String start, String end) {
        this.start = start;
        this.end = end;
    }
    @XmlAttribute(name = "Start")
    public String getStart() {
        return start;
    }
    @XmlAttribute(name = "End")
    public String getEnd() {
        return end;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
