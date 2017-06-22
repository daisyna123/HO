package com.xml;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class TCSL_PARAM_AddOrder_SpecialRequest {
    private List<String> text;

    public TCSL_PARAM_AddOrder_SpecialRequest() {
    }

    public TCSL_PARAM_AddOrder_SpecialRequest(List<String> text) {
        this.text = text;
    }
    @XmlElement(name = "TEXT")
    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
