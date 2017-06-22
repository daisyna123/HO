package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_Profile {
    private TCSL_PARAM_AddOrder_Customer customer;

    public TCSL_PARAM_AddOrder_Profile() {
    }

    public TCSL_PARAM_AddOrder_Profile(TCSL_PARAM_AddOrder_Customer customer) {
        this.customer = customer;
    }
    @XmlElement(name = "Customer")
    public TCSL_PARAM_AddOrder_Customer getCustomer() {
        return customer;
    }

    public void setCustomer(TCSL_PARAM_AddOrder_Customer customer) {
        this.customer = customer;
    }
}
