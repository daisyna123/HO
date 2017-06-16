package com.xml;/**
 * Created by administrator on 2017-06-15.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-06-15
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TCSL_XML_Errors {
    @XmlElement(name="Error")
    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
