package com.xml;/**
 * Created by administrator on 2017-06-15.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @DESCRIPTION 房态的解析xml  javabean
 * @AUTHER administrator zhangna
 * @create 2017-06-15
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OTA_HotelAvailNotifRS")
public class TCSL_XML_OTA_HotelAvailNotifRS {
    @XmlElement(name="Success")
    private String success;
    @XmlElement(name="Errors")
    private TCSL_XML_Errors errors;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public TCSL_XML_Errors getErrors() {
        return errors;
    }

    public void setErrors(TCSL_XML_Errors errors) {
        this.errors = errors;
    }
}
