package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_POS {
    private TCSL_PARAM_AddOrder_Source source;

    public TCSL_PARAM_AddOrder_POS() {
    }

    public TCSL_PARAM_AddOrder_POS(TCSL_PARAM_AddOrder_Source source) {
        this.source = source;
    }

    @XmlElement(name = "Source")
    public TCSL_PARAM_AddOrder_Source getSource() {
        return this.source;
    }

    public void setSource(TCSL_PARAM_AddOrder_Source source) {
        this.source = source;
    }
}
