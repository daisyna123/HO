package com.po;

import java.util.Date;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_PO_HotelProduct {
    private String CSHOPID; //pms酒店代码
    private String CCHANNEL;//渠道
    private String CROOMTYPEID;//房型代码
    private String CROOMTYPENAME; //房型名称
    private String CPAYTYPE; //支付方式
    private Date DTUPDATE; //信息更新时间

    public String getCSHOPID() {
        return CSHOPID;
    }

    public void setCSHOPID(String CSHOPID) {
        this.CSHOPID = CSHOPID;
    }

    public String getCCHANNEL() {
        return CCHANNEL;
    }

    public void setCCHANNEL(String CCHANNEL) {
        this.CCHANNEL = CCHANNEL;
    }

    public String getCROOMTYPEID() {
        return CROOMTYPEID;
    }

    public void setCROOMTYPEID(String CROOMTYPEID) {
        this.CROOMTYPEID = CROOMTYPEID;
    }

    public String getCROOMTYPENAME() {
        return CROOMTYPENAME;
    }

    public void setCROOMTYPENAME(String CROOMTYPENAME) {
        this.CROOMTYPENAME = CROOMTYPENAME;
    }

    public String getCPAYTYPE() {
        return CPAYTYPE;
    }

    public void setCPAYTYPE(String CPAYTYPE) {
        this.CPAYTYPE = CPAYTYPE;
    }

    public Date getDTUPDATE() {
        return DTUPDATE;
    }

    public void setDTUPDATE(Date DTUPDATE) {
        this.DTUPDATE = DTUPDATE;
    }
}
