package com.bo;
import com.dao.TCSL_DAO_Hotel;
import com.po.TCSL_PO_HotelProduct;
import com.po.TCSL_PO_ProductActivity;
import com.po.TCSL_PO_ProductFailInfo;
import com.po.TCSL_PO_RoomStatus;
import com.util.TCSL_UTIL_COMMON;
import com.util.TCSL_UTIL_RESOURCE;
import com.util.TCSL_UTIL_XML;
import com.vo.*;

import com.xml.TCSL_XML_PMSHotelMappingResult;
import com.xml.TCSL_XML_PmsHotelInfoRS;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
@Repository
public class TCSL_BO_Hotel {
    @Autowired
    private TCSL_DAO_Hotel daoHotel;
    private Logger logger = Logger.getLogger(TCSL_BO_Hotel.class);
    /**
     * 上传酒店信息，酒店产品信息
     * @param hotelInfo
     * @return
     */
    public TCSL_VO_Result uploadHotelInfo(TCSL_VO_HotelInfo hotelInfo){
        logger.info("进入uploadHotelInfo()上传酒店信息产品信息方法");
        TCSL_VO_Result result = new TCSL_VO_Result();
        Properties otaProperty = TCSL_UTIL_COMMON.getProperties("ota.properties"); //OTA配置文件中相关信息
        /**
         * 1.将数据库中不存在的产品拼成待上传产品列表
         */
        //1.1将数据库所有产品查询出来组成map<数据库复合主键,数据库映射类po>，便于快速判断产品是否存在数据库中
        String shopId = hotelInfo.getHotelCode(); //pms酒店编号
        List<TCSL_PO_HotelProduct> dbProducts = daoHotel.getProducts(shopId); //获取数据库中酒店产品列表
        String[] keyArr = {"CSHOPID","CCHANNEL","CROOMTYPEID","CPAYTYPE"}; //不同参数顺序，生成key不同
        List<String> keyList = Arrays.asList(keyArr);
        Map<String,TCSL_PO_HotelProduct> dbProductsMap = TCSL_UTIL_COMMON.changeToMap(dbProducts,keyList);
        //1.2遍历hotelInfo中产品列表，比对map中数据，创建出待上传产品列表
        List<TCSL_VO_HotelProduct> products = hotelInfo.getProducts(); //请求参数中产品列表
        List<TCSL_VO_HotelProduct> uploadProducts = new ArrayList<TCSL_VO_HotelProduct>(); //待上传OTA产品列表
        for (TCSL_VO_HotelProduct product :products) {
            if (product == null) { //参数中产品信息为空，解析下一个
                continue;
            }
            String channel = product.getChannel(); //产品应用渠道
            String roomType = product.getRoomTypeCode(); //产品房型编码
            String payType = product.getBalanceType(); //产品支付方式
            String[] paramArr = {shopId,channel,roomType,payType};
            boolean checkResult = TCSL_UTIL_COMMON.checkParmIsValid(paramArr); //校验关键参数是否存在空，防止主键值为空，无法插入数据库
            if(checkResult == true){
                result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_INVALIDPARAM);//400
                result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_INVALIDPARAM);//参数不全
                result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_FAIL); //失败
                return result;
            }
            //查看数据库中是否存在该产品
            String key = shopId+channel+roomType+payType;
            //去空格str = .replaceAll("\\s*", "");可以替换大部分空白字符， 不限于空格;\s 可以匹配空格、制表符、换页符等空白字符的其中任意一个。
            key = key.replaceAll("\\s*",""); //去除参数中空格
            TCSL_PO_HotelProduct dbProduct = dbProductsMap.get(key);
            if(dbProduct == null){
                uploadProducts.add(product);
            }
        }
        /**
         * 2.将待上传产品转换成soapBody所要求的xml
         */
        OMElement hotelXml = createHotelXml(hotelInfo,uploadProducts,otaProperty);
        logger.debug("uploadHotelInfo()---发送soap请求xml---"+hotelXml);
        /**
         * 3.发送soap请求，上传酒店及产品信息
         */
        String url = otaProperty.getProperty("ota_uploadHotelInfo_url");
        String soapAction = otaProperty.getProperty("ota_uploadHotelInfo_soapAction");
        String soapResponse = TCSL_UTIL_XML.sendSoap(url,soapAction,hotelXml);
        logger.debug("uploadHotelInfo()--发送soap响应---"+soapResponse);
        //测试数据
        /*String soapResponse = "<PmsHotelInfoRS xmlns=\"http://www.opentravel.org/OTA/2003/05\">\n" +
                "\t<PMSHotelMappingResults>\n" +
                "\t\t<PMSHotelMappingResult>\n" +
                "\t\t<Channel>Ctrip</Channel>\n" +
                "\t\t<HotelCode>HY2403</HotelCode>\n" +
                "\t\t<RoomTypeCode>BT2</RoomTypeCode>\n" +
                "\t\t<RatePlanCode>P_XCB1</RatePlanCode>\n" +
                "\t\t<IsSuccess>false</IsSuccess>\n" +
                "\t\t<ErrorCode>101</ErrorCode>\n" +
                "\t\t<Message>产品已经存在</Message>\n" +
                "\t\t</PMSHotelMappingResult>\n" +
                "\t\t<PMSHotelMappingResult>\n" +
                "\t\t<Channel>Ctrip</Channel>\n" +
                "\t\t<HotelCode>HY2403</HotelCode>\n" +
                "\t\t<RoomTypeCode>BT</RoomTypeCode>\n" +
                "\t\t<RatePlanCode>P_XCB1</RatePlanCode>\n" +
                "\t\t<IsSuccess>false</IsSuccess>\n" +
                "\t\t<ErrorCode>101</ErrorCode>\n" +
                "\t\t<Message>产品已经存在</Message>\n" +
                "\t\t</PMSHotelMappingResult>\n" +
                "\t</PMSHotelMappingResults>\n" +
                "</PmsHotelInfoRS>\n";*/
        //将soapResponse转换成bean对象
        TCSL_XML_PmsHotelInfoRS productResult = TCSL_UTIL_XML.xmlTojavaBean(TCSL_XML_PmsHotelInfoRS.class,soapResponse);
        //判断是否创建失败
        int size = productResult.getpMSHotelMappingResults().getpMSHotelMappingResult().size();
        boolean isSucess = Boolean.parseBoolean(productResult.getpMSHotelMappingResults().getpMSHotelMappingResult().get(0).getIsSuccess());
        if(size==1 && isSucess == false){
            String msg = productResult.getpMSHotelMappingResults().getpMSHotelMappingResult().get(0).getMessage();
            result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_OTA);//401
            result.setErrorText(msg);//上传OTA失败信息
            result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_FAIL); //失败
            return result;
        }
        /**
         * 4.解析产品创建结果
         */
        List<TCSL_VO_ProductResult> productResults = analyzeProducts(productResult); //产品创建结果列表
        /**
         * 5.判断所有待上传产品是否创建成功
         */
        for (TCSL_VO_HotelProduct product:uploadProducts){
            String channel = product.getChannel();
            String roomTypeId = product.getRoomTypeCode();
            List<TCSL_PO_ProductFailInfo> failList = daoHotel.getFailInfo(shopId,channel,roomTypeId); //酒店产品创建失败记录表
            if(failList.isEmpty()){
                daoHotel.addOrUpdateHotel(hotelInfo,channel);
                daoHotel.addOrUpdateProduct(shopId,product);
            }else{
                result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_PRODUCTFAIL);
                result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_PRODUCTFAIL);
                result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_FAIL);
            }

        }
        result.setData(productResults);
        //成功
        if(result.getErrorCode() == null){
            result.setErrorCode(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_CODE_SUCCESS);
            result.setErrorText(TCSL_UTIL_RESOURCE.RESOURCE_ERROR_DES_SUCCESS);
            result.setReturnCode(TCSL_UTIL_RESOURCE.RESOURCE_RETRUN_CODE_SUCCESS);
        }
        return result;
    }

    /**
     * 解析酒店产品创建结果
     * @param hotelInfoRs soap响应xml对应javaBean
     * @return
     */
    public List<TCSL_VO_ProductResult> analyzeProducts(TCSL_XML_PmsHotelInfoRS hotelInfoRs){
        List<TCSL_VO_ProductResult> result = new ArrayList<TCSL_VO_ProductResult>();
        /**
         * 1.解析hotelInfoRs，判断每个产品活动创建结果，将失败的存入数据库失败记录表
         * 2.成功的记录，去数据库失败记录表删除对应的记录
         */
        if(hotelInfoRs == null || (hotelInfoRs!=null && hotelInfoRs.getpMSHotelMappingResults() == null)){ //创建产品结果为空
            return result;
        }
        List<TCSL_XML_PMSHotelMappingResult> productResult = hotelInfoRs.getpMSHotelMappingResults().getpMSHotelMappingResult();
        //遍历解析产品创建结果列表
        for (TCSL_XML_PMSHotelMappingResult xmlProductResult:productResult){
            if(productResult == null){
                continue;
            }
            //单个产品创建结果信息
            TCSL_VO_ProductResult voProductResult = new TCSL_VO_ProductResult(xmlProductResult);
            String channel = voProductResult.getChannel().toUpperCase();
            String hotelCode = voProductResult.getHotelCode();
            String roomTypeCode = voProductResult.getRoomTypeCode();
            String ratePlanCode = voProductResult.getRatePlanCode();
            boolean isSuccess = voProductResult.getIsSuccess();
            String message = voProductResult.getMessage();
            /**
             * 判断该产品是否创建过
             */
            //判断产品是否已创建成功
            String payType = daoHotel.getProductPayType(channel,ratePlanCode); //支付方式
            TCSL_PO_HotelProduct dbProduct = daoHotel.getProduct(hotelCode,channel,roomTypeCode,payType);
            if(dbProduct != null){
                continue;
            }
            if(true == isSuccess){//产品创建成功,删除失败日志表中记录
                daoHotel.deleteFailInfo(hotelCode,channel,roomTypeCode,ratePlanCode);
            }else{ //产品创建失败，添加失败记录
                TCSL_PO_ProductFailInfo faliInfo = daoHotel.getFailInfoSingle(hotelCode,channel,roomTypeCode,ratePlanCode);
                if(faliInfo == null){
                    daoHotel.addFailInfo(hotelCode,channel,roomTypeCode,ratePlanCode,message);
                }else{
                    daoHotel.updateFailInfo(hotelCode,channel,roomTypeCode,ratePlanCode,message);
                }
            }
            result.add(voProductResult);
        }
        return result;
    }
    /**
     * hotelInfo转换成OTA接口所需xml
     * @param hotelInfo 酒店信息
     * @param products 待上传产品列表
     * @param otaProperty ota相关配置信息
     * @return
     */
    public OMElement createHotelXml(TCSL_VO_HotelInfo hotelInfo,List<TCSL_VO_HotelProduct> products,Properties otaProperty){
        List<TCSL_PO_ProductActivity> activities = daoHotel.getProductActivity(); //OTA所有活动列表
        OMFactory factory = OMAbstractFactory.getOMFactory();
        String nameSpaceProperty =  otaProperty.getProperty("ota_uploadHotelInfo_nameSpace");
        OMNamespace namespace = factory.createOMNamespace(nameSpaceProperty,"");
        OMElement pmsHotelInfoRQTag = factory.createOMElement("PmsHotelInfoRQ",namespace);
        OMElement pMSBaseHotelInfosTag = factory.createOMElement("PMSBaseHotelInfos",null);
        OMElement pMSHotelInfoTag = factory.createOMElement("PMS_Hotel_Info",null);

        String hotelCode = hotelInfo.getHotelCode(); //酒店编码
        String hotelName = hotelInfo.getHotelName(); //酒店名称
        String telephone = hotelInfo.getTelephone(); //酒店联系电话
        String address = hotelInfo.getAddress(); //酒店地址
        String email = hotelInfo.getEmail(); //酒店联系邮箱
        String city = hotelInfo.getHotelCityName(); //酒店所在城市名称
        String province = hotelInfo.getProvinceCode(); //酒店所在省份
        OMElement hotelCodeTag = factory.createOMElement("HotelCode",null); //酒店编码标签
        hotelCodeTag.setText(hotelCode);
        OMElement hotelNameTag = factory.createOMElement("HotelName",null); //酒店名称标签
        hotelNameTag.setText(hotelName);
        OMElement groupTag = factory.createOMElement("HotelGroupCode",null); //OTA商户组标签，使用2.0模式进行对接
        groupTag.setText("TCSL2");
        OMElement telephoneTag = factory.createOMElement("Telephone",null); //酒店联系电话标签
        telephoneTag.setText(telephone);
        OMElement addressTag = factory.createOMElement("Address",null); //酒店地址标签
        addressTag.setText(address);
        OMElement emailTag = factory.createOMElement("Email",null); //酒店联系邮箱标签
        emailTag.setText(email);
        OMElement cityTag = factory.createOMElement("HotelCityName",null); //酒店所在城市名称标签
        cityTag.setText(city);
        OMElement provinceTag = factory.createOMElement("ProvinceCode",null); //酒店所在省份标签
        provinceTag.setText(province);
        pMSHotelInfoTag.addChild(hotelCodeTag);
        pMSHotelInfoTag.addChild(hotelNameTag);
        pMSHotelInfoTag.addChild(groupTag);
        pMSHotelInfoTag.addChild(telephoneTag);
        pMSHotelInfoTag.addChild(addressTag);
        pMSHotelInfoTag.addChild(emailTag);
        pMSHotelInfoTag.addChild(cityTag);
        pMSHotelInfoTag.addChild(provinceTag);
        OMElement pmsHotelProductInfosTag = factory.createOMElement("PmsHotelProductInfos",null); //酒店所有产品列表标签
        //遍历products
        for (TCSL_VO_HotelProduct product:products){
            for (TCSL_PO_ProductActivity activity:activities){
                if(!activity.getCCHANNEL().equals(product.getChannel())){ //产品应用渠道 与 线上活动渠道不符合
                    continue;
                }
                if(!activity.getCPAYTYPE().equals(product.getBalanceType())){ //产品应用支付方式 与 线上活动支付方式不符合
                    continue;
                }
                OMElement pMSProductInfoTag = factory.createOMElement("PMS_Product_Info",null); //产品信息标签
                //房型标签
                OMElement roomTypeTag = factory.createOMElement("RoomTypeCode",null);
                roomTypeTag.setText(product.getRoomTypeCode());
                pMSProductInfoTag.addChild(roomTypeTag);
                //房型名称
                OMElement roomNameTag = factory.createOMElement("RoomTypeName",null);
                roomNameTag.setText(product.getRoomTypeName());
                pMSProductInfoTag.addChild(roomNameTag);
                //OTA活动编码
                OMElement activityCodeTag = factory.createOMElement("RatePlanCode",null);
                activityCodeTag.setText(activity.getCACTIVITYID());
                pMSProductInfoTag.addChild(activityCodeTag);
                //支付类型
                OMElement balanceTypeTag = factory.createOMElement("BalanceType",null);
                balanceTypeTag.setText(product.getBalanceType());
                pMSProductInfoTag.addChild(balanceTypeTag);
                //OTA活动名称
                OMElement activityNameTag = factory.createOMElement("RatePlanName",null);
                activityNameTag.setText(activity.getCACTIVITYNAME());
                pMSProductInfoTag.addChild(activityNameTag);
                //渠道
                OMElement channelTag = factory.createOMElement("Channel",null);
                channelTag.setText(product.getChannel());
                pMSProductInfoTag.addChild(channelTag);
                pmsHotelProductInfosTag.addChild(pMSProductInfoTag);
            }
        }
        pMSHotelInfoTag.addChild(pmsHotelProductInfosTag);
        pMSBaseHotelInfosTag.addChild(pMSHotelInfoTag);
        pmsHotelInfoRQTag.addChild(pMSBaseHotelInfosTag);
        return pmsHotelInfoRQTag;
    }

    /**
     * 上传房态逻辑部分
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
//        result = uploadRSOTA(dbRoomStatus);
        return  result;
    }

    /**
     * 上传房价逻辑部分
     * @param roomPrice 房价信息
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
