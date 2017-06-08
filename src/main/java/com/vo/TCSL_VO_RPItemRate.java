package com.vo;

/**
 * Created by zhangtuoyu on 2017/6/7.
 */
public class TCSL_VO_RPItemRate {
    private String mon; //周一是否生效
    private String tue; //周二是否生效
    private String weds; //周三是否生效
    private String thur; //周四是否生效
    private String fri; //周五是否生效
    private String sat; //周六是否生效
    private String sun; //周日是否生效
    private String rateTimeUnit; //房价应用单位，一般为DAY
    private String invTypeCode; //房型代码
    private String currencyCode; //货币类型，一般为RMB
    private String numberOfGuests; //一般为2，两人价
    private String ageQualifyingCode; //客人类型 一般为10 表示成人
    private String amountBeforeTax; //税前房价
    private String amountAfterTax; //税后房价
    private Boolean breakfast; //是否处理早餐
    private String numberOfBreakfast; //早餐份数


    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getTue() {
        return tue;
    }

    public void setTue(String tue) {
        this.tue = tue;
    }

    public String getWeds() {
        return weds;
    }

    public void setWeds(String weds) {
        this.weds = weds;
    }

    public String getThur() {
        return thur;
    }

    public void setThur(String thur) {
        this.thur = thur;
    }

    public String getFri() {
        return fri;
    }

    public void setFri(String fri) {
        this.fri = fri;
    }

    public String getSat() {
        return sat;
    }

    public void setSat(String sat) {
        this.sat = sat;
    }

    public String getSun() {
        return sun;
    }

    public void setSun(String sun) {
        this.sun = sun;
    }

    public String getRateTimeUnit() {
        return rateTimeUnit;
    }

    public void setRateTimeUnit(String rateTimeUnit) {
        this.rateTimeUnit = rateTimeUnit;
    }

    public String getInvTypeCode() {
        return invTypeCode;
    }

    public void setInvTypeCode(String invTypeCode) {
        this.invTypeCode = invTypeCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(String numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getAgeQualifyingCode() {
        return ageQualifyingCode;
    }

    public void setAgeQualifyingCode(String ageQualifyingCode) {
        this.ageQualifyingCode = ageQualifyingCode;
    }

    public String getAmountBeforeTax() {
        return amountBeforeTax;
    }

    public void setAmountBeforeTax(String amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }

    public String getAmountAfterTax() {
        return amountAfterTax;
    }

    public void setAmountAfterTax(String amountAfterTax) {
        this.amountAfterTax = amountAfterTax;
    }

    public Boolean getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Boolean breakfast) {
        this.breakfast = breakfast;
    }

    public String getNumberOfBreakfast() {
        return numberOfBreakfast;
    }

    public void setNumberOfBreakfast(String numberOfBreakfast) {
        this.numberOfBreakfast = numberOfBreakfast;
    }
}
