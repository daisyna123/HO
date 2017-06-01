package com.vo;
import java.util.List;

/**
 * @DESCRIPTION 房间的状态
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_VO_RoomStatus {
    //PMS酒店代码
    private String hotelCode;
    //可以传递多个产品的房态，或者同一产品不同日期的房态
    private List<TCSL_VO_RSItem> projects;

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public List<TCSL_VO_RSItem> getProjects() {
        return projects;
    }

    public void setProjects(List<TCSL_VO_RSItem> projects) {
        this.projects = projects;
    }
}
