package com.vo;

import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/7.
 */
public class TCSL_VO_RoomPrice {
    private String hotelCode; //酒店编码
    private List<TCSL_VO_RPItem> projects; //酒店房价信息列表

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public List<TCSL_VO_RPItem> getProjects() {
        return projects;
    }

    public void setProjects(List<TCSL_VO_RPItem> projects) {
        this.projects = projects;
    }
}
