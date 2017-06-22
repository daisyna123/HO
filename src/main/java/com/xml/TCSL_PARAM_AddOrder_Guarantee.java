package com.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_Guarantee {
    private String guaranteeType;

    public TCSL_PARAM_AddOrder_Guarantee() {
    }

    public TCSL_PARAM_AddOrder_Guarantee(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }
    @XmlAttribute(name = "GuaranteeType")
    public String getGuaranteeType() {
        return guaranteeType;
    }

    public void setGuaranteeType(String guaranteeType) {
        this.guaranteeType = guaranteeType;
    }
}
