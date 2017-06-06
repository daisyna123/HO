package com.xml;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @DESCRIPTION 上传房态返回响应
 * @AUTHER administrator zhangna
 * @create 2017-06-05
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "OTA_HotelAvailNotifRS",namespace = "http://www.opentravel.org/OTA/2003/05")
public class HotelAvailNotifRS {
    private String error;
    private String success;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }
}
