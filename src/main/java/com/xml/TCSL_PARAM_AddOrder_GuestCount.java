package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"ageQualifyingCode","count"})
public class TCSL_PARAM_AddOrder_GuestCount {
    private String ageQualifyingCode;
    private String count;

    public TCSL_PARAM_AddOrder_GuestCount(String ageQualifyingCode) {
        this.ageQualifyingCode = ageQualifyingCode;
    }

    public TCSL_PARAM_AddOrder_GuestCount() {
    }
    @XmlAttribute(name = "AgeQualifyingCode")
    public String getAgeQualifyingCode() {
        return this.ageQualifyingCode;
    }
    @XmlAttribute(name = "Count")
    public String getCount() {
        return this.count;
    }

    public void setAgeQualifyingCode(String ageQualifyingCode) {
        this.ageQualifyingCode = ageQualifyingCode;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
