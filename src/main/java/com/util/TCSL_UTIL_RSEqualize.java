package com.util;


import com.bo.TCSL_BO_Hotel;
import com.dao.TCSL_DAO_Hotel;
import com.po.TCSL_PO_RoomStatus;
import com.po.TCSL_PO_RsEqualize;
import com.vo.TCSL_VO_RSItem;
import com.xml.TCSL_XML_OTA_HotelAvailNotifRS;
import org.apache.axiom.om.OMElement;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 上传OTA房态补偿线程
 * Created by zhangtuoyu on 2017/6/12.
 */
public class TCSL_UTIL_RSEqualize extends Thread{
    private Logger logger = Logger.getLogger(TCSL_UTIL_RSEqualize.class);
    private TCSL_DAO_Hotel daoHotel = (TCSL_DAO_Hotel)TCSL_UTIL_SpringContext.getBeanByClass(TCSL_DAO_Hotel.class);
    private TCSL_BO_Hotel boHotel = (TCSL_BO_Hotel)TCSL_UTIL_SpringContext.getBeanByClass(TCSL_BO_Hotel.class);
    @Override
    public void run() {
        while (!TCSL_UTIL_COMMON.rsEqualize.isInterrupted()){
            logger.info("TCSL_UTIL_RSEqualize is running ");
            try {
                /**
                 * 1.获取所有未上传成功房态数据列表
                 * 2.转换为TCSL_VO_RoomStatus列表(可能存在多个酒店的为上传成功房态)
                 */
                List<TCSL_PO_RsEqualize> unuploadRs = daoHotel.getUnUploadRs();
                //没有待补偿上传数据,停止补偿线程
                if(unuploadRs == null || unuploadRs.size() == 0){
                    TCSL_UTIL_COMMON.rsEqualize.interrupt();
                }
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
                /**
                 * 3.转换成soapXml,发送soap请求
                 */
                Set<String> keySet = map.keySet();
                Iterator<String> ite = keySet.iterator();
                while (ite.hasNext()){ //挨个处理每个酒店的待上传房态
                    String hotelCode = ite.next();
                    List<TCSL_VO_RSItem> items = map.get(hotelCode);
                    //创建xml数据
                    OMElement OTA_HotelAvailNotifRQ = boHotel.createRsXml(hotelCode,items,p);
                    //发送soap请求
                    String url = p.getProperty("ota_uploadRoomStatus_url");
                    String soapStr = TCSL_UTIL_XML.sendSoap(url,"",OTA_HotelAvailNotifRQ);
                    if(!"".equals(soapStr)){
                        /**
                         * 将线上活动列表聚合出线下房态方案列表
                         */
                        Set<TCSL_PO_RoomStatus> rsSet = new HashSet<TCSL_PO_RoomStatus>(); //待更新OTA上传时间 房态方案列表
                        for (TCSL_VO_RSItem item : items) {
                            TCSL_PO_RoomStatus roomStatus = new TCSL_PO_RoomStatus();
                            roomStatus.setCSHOPID(hotelCode);
                            roomStatus.setCPLANID(item.getCPLANID());
                            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date date = sdf.parse(item.getDTUPLOAD());
                            roomStatus.setDTUPLOAD(date);
                            for(String channel : item.getDestinationSystemCodes()){
                                roomStatus.setCCHANNEL(channel);
                                rsSet.add(roomStatus);
                            }
                        }
                        TCSL_XML_OTA_HotelAvailNotifRS res = TCSL_UTIL_XML.xmlTojavaBean(TCSL_XML_OTA_HotelAvailNotifRS.class,soapStr);
                        //判断OTA解析是否成功
                        if(res.getErrors() == null || "".equals(res.getErrors())){ //OTA解析成功
                            /**
                             * 批量更新房态方案上传OTA时间
                             */
                            //将房态数据按渠道拆分
                            Iterator<TCSL_PO_RoomStatus> rsIte = rsSet.iterator();
                            while (rsIte.hasNext()){
                                TCSL_PO_RoomStatus poRoomStatus = rsIte.next();
                                String shopId = poRoomStatus.getCSHOPID();
                                String planId = poRoomStatus.getCPLANID();
                                String channel = poRoomStatus.getCCHANNEL();
                                Date dtUpload = poRoomStatus.getDTUPLOAD();
                                String dtUploadStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dtUpload);
                                daoHotel.updateRsOtaTime(shopId,planId,channel,dtUploadStr);
                            }
                        }
                    }
                }
            }catch (Exception e){
                logger.info("TCSL_UTIL_RSEqualize is interrupted");
                e.printStackTrace();
                TCSL_UTIL_COMMON.rsEqualize.interrupt();
            }
        }
    }
}
