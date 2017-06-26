package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"effectiveDate","expireDate","rateTimeUnit","unitMultiplier","base"})
public class TCSL_PARAM_AddOrder_Rate {
    private String effectiveDate;
    private String expireDate;
    private String rateTimeUnit;
    private String unitMultiplier;
    private TCSL_PARAM_AddOrder_Base base;

    public TCSL_PARAM_AddOrder_Rate() {
    }

    public TCSL_PARAM_AddOrder_Rate(String effectiveDate, String expireDate, String rateTimeUnit, String unitMultiplier, TCSL_PARAM_AddOrder_Base base) {
        this.effectiveDate = effectiveDate;
        this.expireDate = expireDate;
        this.rateTimeUnit = rateTimeUnit;
        this.unitMultiplier = unitMultiplier;
        this.base = base;
    }

    @XmlAttribute(name = "EffectiveDate")
    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
    @XmlAttribute(name = "ExpireDate")
    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
    @XmlAttribute(name = "RateTimeUnit")
    public String getRateTimeUnit() {
        return rateTimeUnit;
    }

    public void setRateTimeUnit(String rateTimeUnit) {
        this.rateTimeUnit = rateTimeUnit;
    }
    @XmlAttribute(name = "UnitMultiplier")
    public String getUnitMultiplier() {
        return unitMultiplier;
    }

    public void setUnitMultiplier(String unitMultiplier) {
        this.unitMultiplier = unitMultiplier;
    }
    @XmlElement(name = "Base")
    public TCSL_PARAM_AddOrder_Base getBase() {
        return base;
    }

    public void setBase(TCSL_PARAM_AddOrder_Base base) {
        this.base = base;
    }
}
