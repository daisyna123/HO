package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_Profiles {
    private TCSL_PARAM_AddOrder_ProfileInfo profileInfo;

    public TCSL_PARAM_AddOrder_Profiles() {
    }

    public TCSL_PARAM_AddOrder_Profiles(TCSL_PARAM_AddOrder_ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }
    @XmlElement(name = "ProfileInfo")
    public TCSL_PARAM_AddOrder_ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(TCSL_PARAM_AddOrder_ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
    }
}
