package com.bo;
import com.po.TCSL_PO_HotelProduct;
import com.po.TCSL_PO_RoomStatus;
import com.util.TCSL_UTIL_COMMON;
import com.util.TCSL_UTIL_RESOURCE;
import com.util.TCSL_UTIL_XMLData;
import com.vo.*;

import com.xml.PMSHotelMappingResult;
import com.xml.PmsHotelInfoRS;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
@Repository
public class TCSL_BO_Hotel {
    private Logger logger = Logger.getLogger(TCSL_BO_Hotel.class);
    /**
     * 上传酒店信息，酒店产品信息
     * @param hotelInfo
     * @return
     */
    public TCSL_VO_Result uploadHotelInfo(TCSL_VO_HotelInfo hotelInfo){
        logger.info("进入uploadHotelInfo()上传酒店信息产品信息方法");
        //上传OTA酒店及产品数据
        TCSL_VO_Result result  = uploadHotelOTA(hotelInfo);
        //判断是否上传成功
        if(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_SUCCESS.equals(result.getErrorCode()) && TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_SUCCESS.equals(result.getErrorText()) && result.getReturnCode()==TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_SUCCESS){
            //if(200 成功 1)
            //产品创建结果列表
            List<TCSL_VO_ProductResult> list = ((TCSL_VO_HIResult)result.getData()).getResult();
            //hotelInfo中products整合为一个map，用于快速查找到产品信息  与顺序有关
            String[] keys = {"channel","roomTypeCode","ratePlanCode"};
            List<String> fieldList = Arrays.asList(keys);
            Map map = TCSL_UTIL_COMMON.mapUtil(hotelInfo.getProducts(),fieldList);
            //检查上传酒店各项产品的状态
            Boolean checkResult =  checkProduct(list,map);
            if(checkResult == false){
                result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_SYSTEM);//500
                result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_SYSTEM);//系统错误
                result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_FAIL); //失败
                return result;
            }
        }else{
            return result;
        }
        return result;
    }

    /**
     * 检查上传酒店各项产品的状态
     * 说明：对创建成功,数据库中不存在的进行添加;
     *      对产品上传重复,数据库中存在的产品进行信息覆盖
     * @param list 酒店上传产品结果列表
     * @param map 酒店上传产品信息列表
     * @return
     */
    public Boolean checkProduct(List<TCSL_VO_ProductResult> list,Map<String,TCSL_VO_HotelProduct> map){
        //数据库中所有产品列表
        List<TCSL_PO_HotelProduct> dbHotelProducts = new ArrayList<TCSL_PO_HotelProduct>();
        //1.查询数据库所有产品 调用dao层queryProducts()
        //TODO
        //test start
        TCSL_PO_HotelProduct hotelProduct = new TCSL_PO_HotelProduct();
        hotelProduct.setId("1");
        hotelProduct.setHotelName("天财商龙");
        hotelProduct.setPrice("123");
        TCSL_PO_HotelProduct hotelProduct1 = new TCSL_PO_HotelProduct();
        hotelProduct1.setId("2");
        hotelProduct1.setHotelName("测试1");
        hotelProduct1.setPrice("123");
        TCSL_PO_HotelProduct hotelProduct2 = new TCSL_PO_HotelProduct();
        hotelProduct2.setId("3");
        hotelProduct2.setHotelName("测试2");
        hotelProduct2.setPrice("123");
        dbHotelProducts.add(hotelProduct);
        dbHotelProducts.add(hotelProduct1);
        dbHotelProducts.add(hotelProduct2);
        //test end

        //2.将数据库中产品信息整合为map，用于快速获取， 与顺序有关
        String[] keys = {"channel","roomTypeCode","ratePlanCode"};
        List<String> fieldList = Arrays.asList(keys);
        Map dbHotelProductMap = TCSL_UTIL_COMMON.mapUtil(dbHotelProducts,fieldList);
        //增加或修改数据库
        for(int j=0;j<list.size();j++){
            String key = "";
            //3.产品创建成功 isSucess=true,dbHotelProductMap里面没有,将产品添加到数据库
            if(list.get(j).getSuccess() == true){
                key = createKey(list.get(j).getChannel(),list.get(j).getRoomTypeCode(),list.get(j).getRatePlanCode());
                TCSL_PO_HotelProduct dbProduct = (TCSL_PO_HotelProduct)dbHotelProductMap.get(key);
                //数据库不存在该产品，添加到数据库
                if(dbProduct == null) {
                    //取到要添加的产品数据
                    TCSL_VO_HotelProduct newProduct = map.get(key);
                    //调用dao层addProduct(newProduct)传入参数newProduct
                    //TODO
                }
            }
            //4.isSucess=false 并且 Code=101(产品已存在) 更新数据库中产品信息
            if(list.get(j).getSuccess() == false && "101".equals(list.get(j).getCode())){
                key = createKey(list.get(j).getChannel(), list.get(j).getRoomTypeCode(),list.get(j).getRatePlanCode());
                //根据键将值放入到数据库
                TCSL_PO_HotelProduct dbProduct = (TCSL_PO_HotelProduct) dbHotelProductMap.get(key);
                TCSL_VO_HotelProduct newProduct = newProduct = map.get(key);
                //如果数据库存在，则更新数据库
                if(dbProduct != null){
                    //取到要更新的vohotelproduct数据

                    //调用dao层updateProduct(newProduct)传入参数newProduct
                    //TODO
                }else{
                    //调用dao层addProduct(newProduct)传入参数newProduct
                    //TODO
                }
            }
        }
        return true;
    }

    /**
     * 上传OTA酒店及产品信息
     * 说明：将数据转换成OTA所需xml形式上传
     * @param hotelInfo
     * @return
     */
    public TCSL_VO_Result uploadHotelOTA(TCSL_VO_HotelInfo hotelInfo){
        TCSL_VO_Result result = new TCSL_VO_Result();
        TCSL_VO_HIResult hiResult = new TCSL_VO_HIResult(); //创建酒店产品结果
        List<TCSL_VO_ProductResult> list = new ArrayList<TCSL_VO_ProductResult>(); //产品创建结果列表
        //对hotelInfo中products进行参数有效性校验
        if(hotelInfo.getProducts()==null || hotelInfo.getProducts().size() == 0){
            result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_INVALIDPARAM);//400
            result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_INVALIDPARAM);//参数不完整
            result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_FAIL); //失败
            return result;
        }
        //将对象TCSL_VO_HotelInfo中数据转换成xml格式
        //TODO
        /**
         * 1.参数校验products中每个TCSL_VO_HotelProduct进行roomTypeCode,ratePlanCode,channel有效性校验
         * 2.判断TCSL_VO_HotelProduct产品信息是否在产品表中，将不在产品表中的产品组成待上传产品列表
         * 3.把待上传产品列表组合成xml
         */
        //调用工具类TCSL_UTIL_COMMON.getproperties()方法读取ota.properties配置文件中的url，nameSpace，soapAction的值
        Properties p = TCSL_UTIL_COMMON.getProperties("ota.properties");
        //获取ota.properties中上传酒店及产品的url路径
        String url=p.getProperty("ota_uploadHotelInfo_url");
        //获取ota.properties中上传酒店及产品的soapAction路径
        String soapAction=p.getProperty("ota_uploadHotelInfo_soapAction");
        // //获取ota.properties中上传酒店及产品的命名空间路径
        String nameSpace=p.getProperty("ota_uploadHotelInfo_nameSpace");
        //向后台OTA发送soap请求
        String soapResponse = TCSL_UTIL_XMLData.getSoapXMLResponse(url,soapAction,nameSpace,"","","");
        //OTA平台返回值是一个XML，解析封装成一个List<TCSL_VO_ProductResult>
        PmsHotelInfoRS responce = TCSL_UTIL_XMLData.xmlTojavaBean(PmsHotelInfoRS.class,soapResponse);
        //解析soap请求响应(产品创建结果)
        List<PMSHotelMappingResult> pmsHotelMappingResultList = responce.getPmsHotelMappingResults().getPmsHotelMappingResultList();
        for(int i = 0;i < pmsHotelMappingResultList.size() ;i++ ){
            TCSL_VO_ProductResult productResult = new TCSL_VO_ProductResult(); //产品创建结果
            productResult.setMessage(pmsHotelMappingResultList.get(i).getMessage());//错误描述
            productResult.setRatePlanCode(pmsHotelMappingResultList.get(i).getRatePlanCode());//厂商线上活动代码
            productResult.setRoomTypeCode(pmsHotelMappingResultList.get(i).getRoomTypeCode());//厂商房型代码
            productResult.setSuccess(Boolean.parseBoolean(pmsHotelMappingResultList.get(i).getIsSuccess()));//创建结果
            productResult.setHotelCode(pmsHotelMappingResultList.get(i).getHotelCode());//厂商酒店代码
            productResult.setCode(pmsHotelMappingResultList.get(i).getErrorCode());//错误代码
            productResult.setChannel(pmsHotelMappingResultList.get(i).getChannel());//渠道

            //用日志把酒店代码、房型代码，房型名称，渠道打印，  打印result
            logger.debug("酒店代码："+pmsHotelMappingResultList.get(i).getHotelCode()+" 房型代码："+pmsHotelMappingResultList.get(i).getRoomTypeCode()
            +" 渠道名称："+pmsHotelMappingResultList.get(i).getChannel());
            //将TCSL_VO_ProductResult添加到List<PMSHotelMappingResult>
            list.add(productResult);

            //判断产品创建是否失败
            String productStatus = pmsHotelMappingResultList.get(i).getIsSuccess();
            if("false".equals(productStatus)){
                if(!"101".equals(pmsHotelMappingResultList.get(i).getErrorCode())){ //失败原因不是产品已存在
                    /**
                     * 将该记录保存到产品创建失败记录表中
                     */
                    //TODO
                }
            }else{ //产品参加线上活动成功
                /**
                 * 删除产品创建记录表中 对应的 错误信息
                 */
                //TODO
            }
        }
        hiResult.setResult(list);
        result.setData(hiResult);
        //判断产品创建成功/失败
        /**
         * 1.遍历待上传产品列表
         * 2.判断每个产品是否在产品创建失败记录表中有记录
         * 3.有错误记录的 在result中放错误信息；没有错误记录的产品 保存到产品表中
         * 4.所有待上传产品都遍历完，errorCode则说明所有产品都创建成功
         */

//      if(result.getErrorCode() == null || "".equals(result.getErrorCode())) {
//          result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_SUCCESS);//成功
//          result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_SUCCESS);//200
//          result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_SUCCESS);//1
//      }
        return result;
    }
    /**
     * 创建key，由channel、hotelCode、roomTypeCode、ratePlanCode组合
     * @param channel
     * @param roomTypeCode
     * @param ratePlanCode
     * @return
     */
    public String createKey(String channel,String roomTypeCode,String ratePlanCode){
        //拼接key字符串
        StringBuilder key = new StringBuilder();
        key.append(channel);
        key.append(roomTypeCode);
        key.append(ratePlanCode);
        //去空格str = .replaceAll("\\s*", "");可以替换大部分空白字符， 不限于空格;\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个。
        String keys = key.toString();
        keys.replaceAll("\\s*","");
        return  keys;
    }



    /**
     * 上传酒店房态逻辑处理
     * @param roomStatus 房态信息
     * @return
     */
    public TCSL_VO_Result uploadRoomStatus(TCSL_VO_RoomStatus roomStatus){
        TCSL_VO_Result result = new TCSL_VO_Result();
        //对roomStatus中projects房态列表有效性验证
        if(roomStatus.getProjects() == null || roomStatus.getProjects().size()==0){
            result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_INVALIDPARAM);//400
            result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_INVALIDPARAM);//参数不完整
            result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_FAIL); //失败
            logger.info("上传的房态信息参数不完整！");
            return  result;
        }
        //产品有效性校验
        List<TCSL_VO_RSItem> validList = new ArrayList<TCSL_VO_RSItem>(); //有效产品列表
        for(TCSL_VO_RSItem obj : roomStatus.getProjects()){
            //参数校验（房态生效时间/PMS房型代码/价格代码/渠道代码/房间状态）是否为空,调用工具类中的checkParmIsValid方法
            ArrayList param = new ArrayList();
            param.add(obj.getDate());
            param.add(obj.getDestinationSystemCodes());
            param.add(obj.getInvTypeCode());
            param.add(obj.getRatePlanCode());
            param.add(obj.getStatus());
            logger.debug("房态生效时间："+obj.getDate()+"渠道："+obj.getDestinationSystemCodes()+"房型代码："+obj.getInvTypeCode());
            if(TCSL_UTIL_COMMON.checkParmIsValid(param)){
                continue;
            }
            validList.add(obj);
        }
        //将房态数据保存到数据库， 调用dao层addRS(validList) 考虑是否可以批量添加
        //TODO
        List<TCSL_PO_RoomStatus> dbRoomStatus = new ArrayList<TCSL_PO_RoomStatus>();
        //查询数据库从当天起向后90天的房态数据调用dao层的queryRS()
        //TODO

        //将数据转换成OTA所需xml形式上传(xml格式 调用uploadRSOTA()
        result = uploadRSOTA(dbRoomStatus);
        return  result;
    }

    /**
     * 将数据转换成OTA所需xml形式上传(xml格式参照《酒店O2O线上程序涉及接口》中样例
     * 说明：1.将对象TCSL_PO_RoomStatus中数据转换成xml格式
     *      2.后台向OTA发送soap请求
     *      3.将返回xml格式的数据，整合成对象TCSL_VO_Result
     * @param po_roomStatuses
     * @return
     */
    public TCSL_VO_Result  uploadRSOTA(List<TCSL_PO_RoomStatus> po_roomStatuses){
        TCSL_VO_Result result = new TCSL_VO_Result();
        //TODO
       /* 1.将对象TCSL_PO_RoomStatus中数据转换成xml格式
        2.后台向OTA发送soap请求
        3.将返回xml格式的数据，整合成对象TCSL_VO_Result*/
        String url="http://124.127.242.67/AutoMappingWS/GetPmsInfo.asmx";
        String soapAction="http://htng.org/2014B/HTNG_ARIAndReservationPushService#GetPMSHotelInfo";
        String nameSpace="xmlns=\"http://www.opentravel.org/OTA/2003/05\"";
        //向后台OTA发送soap请求
        String soapResponse = TCSL_UTIL_XMLData.getSoapXMLResponse(url,soapAction,nameSpace,"","","");
        //将soapResponse转为javabean

        //日志打印result
        return result;
    }

    /**
     * 上传房价逻辑部分
     * @param roomPrice
     * @return
     */
    public TCSL_VO_Result uploadRoomPrice(TCSL_VO_RoomPrice roomPrice){
        TCSL_VO_Result result = new TCSL_VO_Result();
        //酒店代码
        String hotelCode = roomPrice.getHotelCode();
        //酒店价格方案列表
        List<TCSL_VO_RPItem> rpItems =  roomPrice.getProjects();
        //TODO
        return result;
    }
}
