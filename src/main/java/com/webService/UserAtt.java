package com.webService;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
public class UserAtt {

    private String city;
    private String food;

    public UserAtt() {
    }

    public UserAtt(String city, String food) {
        this.city = city;
        this.food = food;
    }

    @XmlAttribute
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
