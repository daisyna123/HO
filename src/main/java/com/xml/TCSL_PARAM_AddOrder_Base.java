package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"amountBeforeTax","amountAfterTax","currencyCode","breakfast"})
public class TCSL_PARAM_AddOrder_Base {
    private String amountBeforeTax;
    private String amountAfterTax;
    private String currencyCode;
    private String breakfast;

    public TCSL_PARAM_AddOrder_Base(String amountBeforeTax, String amountAfterTax, String currencyCode, String breakfast) {
        this.amountBeforeTax = amountBeforeTax;
        this.amountAfterTax = amountAfterTax;
        this.currencyCode = currencyCode;
        this.breakfast = breakfast;
    }

    public TCSL_PARAM_AddOrder_Base() {
    }
    @XmlAttribute(name = "AmountBeforeTax")
    public String getAmountBeforeTax() {
        return this.amountBeforeTax;
    }

    public void setAmountBeforeTax(String amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }
    @XmlAttribute(name = "AmountAfterTax")
    public String getAmountAfterTax() {
        return this.amountAfterTax;
    }

    public void setAmountAfterTax(String amountAfterTax) {
        this.amountAfterTax = amountAfterTax;
    }
    @XmlAttribute(name = "CurrencyCode")
    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
    @XmlAttribute(name = "Breakfast")
    public String getBreakfast() {
        return this.breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }
}
