package com.po;

import java.util.Date;

/**
 * @DESCRIPTION 酒店房态明细表
 * @AUTHER administrator zhangna
 * @create 2017-06-13
 */
public class TCSL_PO_ProductStatusDt {
    private String CPLANID;//线下房态方案编码
    private String CROOMTYPEID;//房型编码
    private Date DBTIME;//房态生效开始时间
    private Date DETIME;//房态生效结束时间
    private Integer IROOMSTATUS;//房间状态 0：该房型关闭 不可售卖1：该房型开放 可售卖

    public String getCPLANID() {
        return CPLANID;
    }

    public void setCPLANID(String CPLANID) {
        this.CPLANID = CPLANID;
    }

    public String getCROOMTYPEID() {
        return CROOMTYPEID;
    }

    public void setCROOMTYPEID(String CROOMTYPEID) {
        this.CROOMTYPEID = CROOMTYPEID;
    }

    public Date getDBTIME() {
        return DBTIME;
    }

    public void setDBTIME(Date DBTIME) {
        this.DBTIME = DBTIME;
    }

    public Date getDETIME() {
        return DETIME;
    }

    public void setDETIME(Date DETIME) {
        this.DETIME = DETIME;
    }

    public Integer getIROOMSTATUS() {
        return IROOMSTATUS;
    }

    public void setIROOMSTATUS(Integer IROOMSTATUS) {
        this.IROOMSTATUS = IROOMSTATUS;
    }
}
