package com.xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_Rates {
    private List<TCSL_PARAM_AddOrder_Rate> rate;

    public TCSL_PARAM_AddOrder_Rates() {
    }

    public TCSL_PARAM_AddOrder_Rates(List<TCSL_PARAM_AddOrder_Rate> rate) {
        this.rate = rate;
    }
    @XmlElement(name = "Rate")
    public List<TCSL_PARAM_AddOrder_Rate> getRate() {
        return rate;
    }

    public void setRate(List<TCSL_PARAM_AddOrder_Rate> rate) {
        rate = rate;
    }
}
