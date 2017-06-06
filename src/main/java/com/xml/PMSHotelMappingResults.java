package com.xml;/**
 * Created by administrator on 2017-06-02.
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @DESCRIPTION 上传酒店信息返回值
 * @AUTHER administrator zhangna
 * @create 2017-06-02
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class PMSHotelMappingResults {
    @XmlElement(name="PMSHotelMappingResult")
    private List<PMSHotelMappingResult> pmsHotelMappingResultList;

    public List<PMSHotelMappingResult> getPmsHotelMappingResultList() {
        return pmsHotelMappingResultList;
    }

    public void setPmsHotelMappingResultList(List<PMSHotelMappingResult> pmsHotelMappingResultList) {
        this.pmsHotelMappingResultList = pmsHotelMappingResultList;
    }
}
