package com.util;


import com.bo.TCSL_BO_Hotel;
import com.dao.TCSL_DAO_Hotel;
import com.po.TCSL_PO_RsEqualize;
import com.vo.TCSL_VO_RSItem;
import org.apache.axiom.om.OMElement;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * 上传OTA房态补偿线程
 * Created by zhangtuoyu on 2017/6/12.
 */
@Repository
public class TCSL_UTIL_RSEqualize extends Thread{
    @Autowired
    private TCSL_DAO_Hotel daoHotel;
    private Logger logger = Logger.getLogger(TCSL_UTIL_RSEqualize.class);
    @Autowired
    private TCSL_BO_Hotel boHotel;
    @Override
    public void run() {
        while (!TCSL_UTIL_COMMON.uploadFusingFlag){
            logger.info("TCSL_UTIL_RSEqualize is running");
            try {
                /**
                 * 1.获取所有未上传成功房态数据列表
                 * 2.转换为TCSL_VO_RoomStatus列表(可能存在多个酒店的为上传成功房态)
                 */
                List<TCSL_PO_RsEqualize> unuploadRs = daoHotel.getUnUploadRs();
                Map<String,List<TCSL_VO_RSItem>> map = new HashMap<String,List<TCSL_VO_RSItem>>(); // key 酒店编码,value 酒店待处理房态数据列表
                for(TCSL_PO_RsEqualize poRsEqualize:unuploadRs){
                    String hotelCode = poRsEqualize.getCSHOPID(); //酒店编码
                    TCSL_VO_RSItem rsItem = new TCSL_VO_RSItem(poRsEqualize); //待处理酒店未上传房态
                    rsItem.getDestinationSystemCodes().add(poRsEqualize.getCCHANNEL());//待处理酒店未上传房态 渠道
                    if(map.get(hotelCode) == null){ //不存在该酒店相关信息，新增到map中
                        List<TCSL_VO_RSItem> list = new ArrayList<TCSL_VO_RSItem>();
                        list.add(rsItem);
                        map.put(hotelCode,list);
                    }else {
                        /**
                         * 1.获取到该酒店待上传房态列表
                         * 2.判断目前房态数据，是否在房态列表中存在
                         * 2.1存在 新增应用渠道
                         * 2.2不存在 添加到房态列表中
                         */
                        List<TCSL_VO_RSItem> list = map.get(hotelCode); //该酒店所有待上传房态信息
                        if(list.contains(rsItem)){ //列表中存在该房型房态信息
                            int index = list.indexOf(rsItem);
                            List<String> channels =  list.get(index).getDestinationSystemCodes(); //放房型 应用渠道列表
                            if(!channels.contains(poRsEqualize.getCCHANNEL())){ //此房型应用渠道列表中不存在
                                channels.add(poRsEqualize.getCCHANNEL()); //此房型应用渠道列表添加该渠道
                            }
                        }else{ //列表中不存在该房型房态信息
                            list.add(rsItem);
                        }
                    }
                }
                Properties p = TCSL_UTIL_COMMON.getProperties("ota.properties");
                long fuseTime = Long.parseLong(p.getProperty("ota_fusing_time")) * 60 * 1000; //熔断恢复时间(ms)
                int equalizeNum = Integer.parseInt(p.getProperty("ota_equalize_num")); //补偿次数

                /**
                 * 3.转换成soapXml
                 */
                Set<String> keySet = map.keySet();
                Iterator<String> ite = keySet.iterator();
                while (ite.hasNext()){ //挨个处理每个酒店的待上传房态
                    String hotelCode = ite.next();
                    List<TCSL_VO_RSItem> items = map.get(hotelCode);
                    OMElement OTA_HotelAvailNotifRQ = boHotel.createRsXml(hotelCode,items,p);
                    /**
                     * 1.发送soap请求
                     * 1.发送成功 修改数据库相关数据上传ota时间，重置补偿次数、熔断标志
                     * 2.发送失败 判断补偿次数是否达到指定数
                     * 2.1 没达到：程序继续执行
                     * 2.2 达到:熔断标志改为true,暂停指定时间
                     */
                    //发送soap请求
                    //TODO
                    //发送成功
                    TCSL_UTIL_COMMON.equalizeNum = 0;
                    TCSL_UTIL_COMMON.uploadFusingFlag = false;
                    //TODO
                    //发送失败
                    TCSL_UTIL_COMMON.equalizeNum = TCSL_UTIL_COMMON.equalizeNum + 1;
                    if(TCSL_UTIL_COMMON.equalizeNum == equalizeNum){
                        TCSL_UTIL_COMMON.uploadFusingFlag = true;
                        break;
                    }
                }
                /**
                 * 补偿逻辑执行完成
                 * 1.所有数据补偿成功,中断线程
                 * 2.达到熔断次数，熔断标记为true,暂停补偿
                 * 3.未达到熔断次数，继续尝试补偿,继续补偿
                 */
                if(TCSL_UTIL_COMMON.uploadFusingFlag == false && TCSL_UTIL_COMMON.equalizeNum == 0){
                    TCSL_UTIL_COMMON.rsEqualize.interrupt();
                }
                if(TCSL_UTIL_COMMON.uploadFusingFlag == true){
                    sleep(fuseTime); //线程暂停补偿
                }

            }catch (Exception e){
                logger.info("TCSL_UTIL_RSEqualize is interrupted");
                TCSL_UTIL_COMMON.rsEqualize.interrupt();
            }
        }
    }
}
