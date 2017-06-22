package com.xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_Customer {
    private List<TCSL_PARAM_AddOrder_PersonName> personName;

    public TCSL_PARAM_AddOrder_Customer() {
    }

    public TCSL_PARAM_AddOrder_Customer(List<TCSL_PARAM_AddOrder_PersonName> personName) {
        this.personName = personName;
    }
    @XmlElement(name = "PersonName")
    public List<TCSL_PARAM_AddOrder_PersonName> getPersonName() {
        return personName;
    }

    public void setPersonName(List<TCSL_PARAM_AddOrder_PersonName> personName) {
        this.personName = personName;
    }
}
