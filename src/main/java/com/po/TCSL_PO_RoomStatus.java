package com.po;
import java.util.Date;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-19
 */
public class TCSL_PO_RoomStatus {
    private String CSHOPID;//pms酒店代码
    private String CCHANNEL;//渠道
    private String CPLANID;//线下房态方案编码
    private String CPLANNAME;//线下房态方案名称
    private Integer IDELFLG;//删除标记 0 不生效1  生效
    private Date DTUPLOAD;//线下上传时间
    private Date DTOTAUPLOAD;//上传OTA时间

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

    public String getCPLANID() {
        return CPLANID;
    }

    public void setCPLANID(String CPLANID) {
        this.CPLANID = CPLANID;
    }

    public String getCPLANNAME() {
        return CPLANNAME;
    }

    public void setCPLANNAME(String CPLANNAME) {
        this.CPLANNAME = CPLANNAME;
    }

    public Integer getIDELFLG() {
        return IDELFLG;
    }

    public void setIDELFLG(Integer IDELFLG) {
        this.IDELFLG = IDELFLG;
    }

    public Date getDTUPLOAD() {
        return DTUPLOAD;
    }

    public void setDTUPLOAD(Date DTUPLOAD) {
        this.DTUPLOAD = DTUPLOAD;
    }

    public Date getDTOTAUPLOAD() {
        return DTOTAUPLOAD;
    }

    public void setDTOTAUPLOAD(Date DTOTAUPLOAD) {
        this.DTOTAUPLOAD = DTOTAUPLOAD;
    }
}
