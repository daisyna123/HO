package com.vo;

import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/7.
 */
public class TCSL_VO_RPItem {
    private String ratePlanCode; //线下价格方案编码
    private String ratePlanName; //线下价格方案名称
    private String ratePlanStart; //线下价格方案应用开始时间
    private String ratePlanEnd; //线下价格方案应用结束时间
    private String currencyCode; //支付货币类型 一般为RMB
    private List<TCSL_VO_RPItemRate> rates; //该价格方案下各种房型信息

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public String getRatePlanName() {
        return ratePlanName;
    }

    public void setRatePlanName(String ratePlanName) {
        this.ratePlanName = ratePlanName;
    }

    public String getRatePlanStart() {
        return ratePlanStart;
    }

    public void setRatePlanStart(String ratePlanStart) {
        this.ratePlanStart = ratePlanStart;
    }

    public String getRatePlanEnd() {
        return ratePlanEnd;
    }

    public void setRatePlanEnd(String ratePlanEnd) {
        this.ratePlanEnd = ratePlanEnd;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public List<TCSL_VO_RPItemRate> getRates() {
        return rates;
    }

    public void setRates(List<TCSL_VO_RPItemRate> rates) {
        this.rates = rates;
    }
}
