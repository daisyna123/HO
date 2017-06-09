package com.po;

/**
 * @DESCRIPTION
 * 酒店产品创建失败记录映射表
 * @AUTHER administrator zhangna
 * @create 2017-06-09
 */
public class TCSL_PO_ProductFailInfo {
    private String CSHOPID;
    private String CCHANNEL;
    private String CROOMTYPEID;
    private String CACTIVITYID;
    private String CFAILINFO;

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

    public String getCACTIVITYID() {
        return CACTIVITYID;
    }

    public void setCACTIVITYID(String CACTIVITYID) {
        this.CACTIVITYID = CACTIVITYID;
    }

    public String getCFAILINFO() {
        return CFAILINFO;
    }

    public void setCFAILINFO(String CFAILINFO) {
        this.CFAILINFO = CFAILINFO;
    }
}
