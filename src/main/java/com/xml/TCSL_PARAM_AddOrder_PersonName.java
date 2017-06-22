package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"givenName","surname"})
public class TCSL_PARAM_AddOrder_PersonName {
    private String givenName;
    private String surname;

    public TCSL_PARAM_AddOrder_PersonName() {
    }

    public TCSL_PARAM_AddOrder_PersonName(String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
    }
    @XmlElement(name = "GivenName")
    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }
    @XmlElement(name = "Surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
