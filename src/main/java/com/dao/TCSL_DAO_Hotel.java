package com.dao;

import com.po.TCSL_PO_HotelProduct;
import com.po.TCSL_PO_ProductActivity;
import com.po.TCSL_PO_ProductFailInfo;
import com.po.TCSL_PO_RoomStatus;
import com.vo.TCSL_VO_HotelInfo;
import com.vo.TCSL_VO_HotelProduct;
import com.vo.TCSL_VO_RSItem;
import com.vo.TCSL_VO_RoomStatus;
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

    /**
     * 添加/更新酒店信息
     * @param hotelInfo
     * @param channel
     */
    public void addOrUpdateHotel(
            @Param("HOTEL")TCSL_VO_HotelInfo hotelInfo,
            @Param("CHANNEL") String channel
    );

    /**
     * 获取OTA活动对应的支付方式
     * @param CCHANNEL
     * @param CACTIVITYID
     * @return
     */
    public String getProductPayType(
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CACTIVITYID") String CACTIVITYID
    );

    /**
     * 获取单个酒店产品记录
     * @param CSHOPID
     * @param CCHANNEL
     * @param CROOMTYPEID
     * @param CPAYTYPE
     * @return
     */
    public TCSL_PO_HotelProduct getProduct(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID,
            @Param("CPAYTYPE") String CPAYTYPE
    );

    /**
     * 获取酒店产品不同支付方式的记录（根据酒店代码、渠道、房型代码）
     * @param CSHOPID
     * @param CCHANNEL
     * @param CROOMTYPEID
     * @return
     */
    public List<TCSL_PO_HotelProduct> getProductStatus(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID
    );

    /**
     * 获取房态是否存在
     * @param CSHOPID
     * @param CCHANNEL
     * @param CPLANID
     * @return
     */
    public TCSL_PO_RoomStatus getRoomState(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CPLANID") String CPLANID
    );

    /**
     * 删除房态明细中的某一条记录
     * @param CPLANID
     * @param CROOMTYPEID
     */
    public void delRoomState(
            @Param("CPLANID") String CPLANID,
            @Param("CROOMTYPEID") String CROOMTYPEID
    );

    /**
     * 添加房态主表信息
     * @param roomStatus
     */
    public void addRoomStatus(
            @Param("roomStatus")TCSL_VO_RoomStatus roomStatus
            );
    public List<TCSL_PO_ProductActivity> getActivity(
            @Param("CSHOPID") String CSHOPID,
            @Param("CCHANNEL") String CCHANNEL,
            @Param("CROOMTYPEID") String CROOMTYPEID
    );
}
