package com.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"profiles","arrivalTransport"})
public class TCSL_PARAM_AddOrder_ResGuest {
    private TCSL_PARAM_AddOrder_Profiles profiles;
    private TCSL_PARAM_AddOrder_ArrivalTransport arrivalTransport;

    public TCSL_PARAM_AddOrder_ResGuest() {
    }

    public TCSL_PARAM_AddOrder_ResGuest(TCSL_PARAM_AddOrder_Profiles profiles, TCSL_PARAM_AddOrder_ArrivalTransport arrivalTransport) {
        this.profiles = profiles;
        this.arrivalTransport = arrivalTransport;
    }
    @XmlElement(name = "Profiles")
    public TCSL_PARAM_AddOrder_Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(TCSL_PARAM_AddOrder_Profiles profiles) {
        this.profiles = profiles;
    }
    @XmlElement(name = "ArrivalTransport")
    public TCSL_PARAM_AddOrder_ArrivalTransport getArrivalTransport() {
        return arrivalTransport;
    }

    public void setArrivalTransport(TCSL_PARAM_AddOrder_ArrivalTransport arrivalTransport) {
        this.arrivalTransport = arrivalTransport;
    }
}
