package com.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-06-08
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PmsHotelInfoRS")
public class TCSL_XML_PmsHotelInfoRS {
    @XmlElement(name="PMSHotelMappingResults")
    private TCSL_XML_PMSHotelMappingResults pMSHotelMappingResult;

    public TCSL_XML_PMSHotelMappingResults getpMSHotelMappingResults() {
        return pMSHotelMappingResult;
    }

    public void setpMSHotelMappingResults(TCSL_XML_PMSHotelMappingResults pMSHotelMappingResult) {
        this.pMSHotelMappingResult = pMSHotelMappingResult;
    }
}
