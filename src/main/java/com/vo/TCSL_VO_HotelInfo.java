package com.vo;
import javax.xml.bind.annotation.*;
import java.util.List;
/**
 * @DESCRIPTION  酒店信息
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_VO_HotelInfo {
    //PMS酒店代码
    private String hotelCode;
    //PMS酒店名称
    private String hotelName;
    //酒店电话号码
    private String telephone;
    //酒店地址
    private String address;
    //酒店邮箱
    private String email;
    //城市
    private String hotelCityName;
    //省份
    private String provinceCode;

    //酒店产品数组
    private List<TCSL_VO_HotelProduct> products;

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotelCityName() {
        return hotelCityName;
    }

    public void setHotelCityName(String hotelCityName) {
        this.hotelCityName = hotelCityName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public List<TCSL_VO_HotelProduct> getProducts() {
        return products;
    }

    public void setProducts(List<TCSL_VO_HotelProduct> products) {
        this.products = products;
    }
}
