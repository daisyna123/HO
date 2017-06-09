package com.dao;

import com.po.TCSL_PO_HotelProduct;
import com.po.TCSL_PO_ProductActivity;
import com.po.TCSL_PO_ProductFailInfo;
import com.vo.TCSL_VO_HotelInfo;
import com.vo.TCSL_VO_HotelProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/7.
 */
public interface TCSL_DAO_Hotel {
    /**
     * 获取该酒店所有产品
     * @param CSHOPID
     * @return
     */
    public List<TCSL_PO_HotelProduct> getProducts(
            @Param("CSHOPID") String CSHOPID
    );

    /**
     * 查询所有线上活动
     * @return
     */
    public List<TCSL_PO_ProductActivity> getProductActivity();

    /**
     * 删除产品创建失败记录
     * @param CSHOPID
     * @param CCHANNEL
     * @param CROOMTYPEID
     * @param CACTIVITYID
     */
    public void deleteFailInfo(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID,
            @Param("CACTIVITYID") String CACTIVITYID
    );

    /**
     * 添加产品创建失败记录
     * @param CSHOPID
     * @param CCHANNEL
     * @param CROOMTYPEID
     * @param CACTIVITYID
     * @param CFAILINFO
     */
    public void addFailInfo(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID,
            @Param("CACTIVITYID") String CACTIVITYID,
            @Param("CFAILINFO") String CFAILINFO
    );
    public void updateFailInfo(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID,
            @Param("CACTIVITYID") String CACTIVITYID,
            @Param("CFAILINFO") String CFAILINFO
    );

    /**
     * 查询酒店产品创建失败记录
     * @param CSHOPID 酒店编码
     * @param CCHANNEL 渠道
     * @param CROOMTYPEID 房型编码
     * @return
     */
    public List<TCSL_PO_ProductFailInfo> getFailInfo(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID
    );

    /**
     * 查询某一条产品创建失败记录
     * @param CSHOPID
     * @param CCHANNEL
     * @param CROOMTYPEID
     * @return
     */
    public TCSL_PO_ProductFailInfo getFailInfoSingle(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID,
            @Param("CACTIVITYID") String CACTIVITYID
    );
    /**
     * 添加酒店产品
     * @param CSHOPID
     * @param product
     */
    public void addOrUpdateProduct(
            @Param("CSHOPID") String CSHOPID,
            @Param("PRODUCT") TCSL_VO_HotelProduct product
    );
    public void addOrUpdateHotel(
            @Param("HOTEL")TCSL_VO_HotelInfo hotelInfo,
            @Param("CHANNEL") String channel
    );
    public String getProductPayType(
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CACTIVITYID") String CACTIVITYID
    );
    public TCSL_PO_HotelProduct getProduct(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID,
            @Param("CPAYTYPE") String CPAYTYPE
    );
}
