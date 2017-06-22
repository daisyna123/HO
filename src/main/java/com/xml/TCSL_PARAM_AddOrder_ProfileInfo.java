package com.xml;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_ProfileInfo {
    private TCSL_PARAM_AddOrder_Profile Profile;

    public TCSL_PARAM_AddOrder_ProfileInfo() {
    }

    public TCSL_PARAM_AddOrder_ProfileInfo(TCSL_PARAM_AddOrder_Profile profile) {
        Profile = profile;
    }
    @XmlElement(name = "Profile")
    public TCSL_PARAM_AddOrder_Profile getProfile() {
        return Profile;
    }

    public void setProfile(TCSL_PARAM_AddOrder_Profile profile) {
        Profile = profile;
    }
}
