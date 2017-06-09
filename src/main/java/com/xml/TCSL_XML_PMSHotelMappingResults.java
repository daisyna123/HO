package com.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-06-08
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class TCSL_XML_PMSHotelMappingResults {
    @XmlElement(name = "PMSHotelMappingResult")
    private List<TCSL_XML_PMSHotelMappingResult> pMSHotelMappingResult;

    public List<TCSL_XML_PMSHotelMappingResult> getpMSHotelMappingResult() {
        return pMSHotelMappingResult;
    }

    public void setpMSHotelMappingResult(List<TCSL_XML_PMSHotelMappingResult> pMSHotelMappingResult) {
        this.pMSHotelMappingResult = pMSHotelMappingResult;
    }
}
