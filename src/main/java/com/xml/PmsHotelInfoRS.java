package com.xml;/**
 * Created by administrator on 2017-06-02.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @DESCRIPTION 上传酒店信息返回值
 * @AUTHER administrator zhangna
 * @create 2017-06-02
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PmsHotelInfoRS")
public class PmsHotelInfoRS {
    @XmlElement(name="PMSHotelMappingResults")
    private PMSHotelMappingResults pmsHotelMappingResults;

    public PMSHotelMappingResults getPmsHotelMappingResults() {
        return pmsHotelMappingResults;
    }

    public void setPmsHotelMappingResults(PMSHotelMappingResults pmsHotelMappingResults) {
        this.pmsHotelMappingResults = pmsHotelMappingResults;
    }
}
