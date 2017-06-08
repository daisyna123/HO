package com.po;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
public class TCSL_PO_Test {
    private String UNAME;
    private Integer AGE;
    private String ADDRESS;

    public String getNAME() {
        return UNAME;
    }

    public void setNAME(String UNAME) {
        this.UNAME = UNAME;
    }

    public Integer getAGE() {
        return AGE;
    }

    public void setAGE(Integer AGE) {
        this.AGE = AGE;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }
}
