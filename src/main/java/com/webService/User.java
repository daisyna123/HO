package com.webService;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/21.
 */

/**
 * @XmlRootElement-指定XML根元素名称（可选）
 * @XmlAccessorType-控制属性或方法序列化 ， 四种方案：
 *  FIELD-对每个非静态，非瞬变属性JAXB工具自动绑定成XML，除非注明XmlTransient
 *  NONE-不做任何处理
 *  PROPERTY-对具有set/get方法的属性进行绑定，除非注明XmlTransient
 *  PUBLIC_MEMBER -对有set/get方法的属性或具有共公访问权限的属性进行绑定，除非注 明XmlTransient
 *  @XmlType-映射一个类或一个枚举类型成一个XML Schema类型
 */
@XmlType(propOrder={"name","address","gender","userAtt","chinese"})
public class User {
    private String name;
    private String address;
    private String gender;
    private UserAtt userAtt;
    private ArrayList<chinese> chinese;

    public User(String name, String address, String gender, UserAtt userAtt, ArrayList<com.webService.chinese> chinese) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.userAtt = userAtt;
        this.chinese = chinese;
    }

    public User() { }
    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @XmlElement
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @XmlElement
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public ArrayList<com.webService.chinese> getChinese() {
        return chinese;
    }

    public void setChinese(ArrayList<com.webService.chinese> chinese) {
        this.chinese = chinese;
    }
    @XmlElement
    public UserAtt getUserAtt() {
        return userAtt;
    }

    public void setUserAtt(UserAtt userAtt) {
        this.userAtt = userAtt;
    }
}
