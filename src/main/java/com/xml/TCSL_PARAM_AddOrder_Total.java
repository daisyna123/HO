package com.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@XmlType(propOrder = {"amountBeforeTax","amountAfterTax","currencyCode"})
public class TCSL_PARAM_AddOrder_Total {
    private String amountBeforeTax;
    private String amountAfterTax;
    private String currencyCode;

    public TCSL_PARAM_AddOrder_Total(String amountBeforeTax, String amountAfterTax, String currencyCode) {
        this.amountBeforeTax = amountBeforeTax;
        this.amountAfterTax = amountAfterTax;
        this.currencyCode = currencyCode;
    }

    public TCSL_PARAM_AddOrder_Total() {
    }
    @XmlAttribute(name = "AmountBeforeTax")
    public String getAmountBeforeTax() {
        return amountBeforeTax;
    }
    @XmlAttribute(name = "AmountAfterTax")
    public String getAmountAfterTax() {
        return amountAfterTax;
    }
    @XmlAttribute(name = "CurrencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setAmountBeforeTax(String amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }

    public void setAmountAfterTax(String amountAfterTax) {
        this.amountAfterTax = amountAfterTax;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}
