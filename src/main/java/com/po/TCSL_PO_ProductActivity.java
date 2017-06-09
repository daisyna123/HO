package com.po;

/**
 * @DESCRIPTION 酒店产品活动类别表
 * @AUTHER administrator zhangna
 * @create 2017-06-08
 */
public class TCSL_PO_ProductActivity {
    private String CCHANNEL;//渠道
    private String CACTIVITYID;//活动类别编号
    private String CACTIVITYNAME;//活动类别名称
    private String CPAYTYPE;//支付方式

    public String getCCHANNEL() {
        return CCHANNEL;
    }

    public void setCCHANNEL(String CCHANNEL) {
        this.CCHANNEL = CCHANNEL;
    }

    public String getCACTIVITYID() {
        return CACTIVITYID;
    }

    public void setCACTIVITYID(String CACTIVITYID) {
        this.CACTIVITYID = CACTIVITYID;
    }

    public String getCACTIVITYNAME() {
        return CACTIVITYNAME;
    }

    public void setCACTIVITYNAME(String CACTIVITYNAME) {
        this.CACTIVITYNAME = CACTIVITYNAME;
    }

    public String getCPAYTYPE() {
        return CPAYTYPE;
    }

    public void setCPAYTYPE(String CPAYTYPE) {
        this.CPAYTYPE = CPAYTYPE;
    }
}
