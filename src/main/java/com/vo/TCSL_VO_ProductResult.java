package com.vo;

import com.xml.TCSL_XML_PMSHotelMappingResult;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-15
 */
public class TCSL_VO_ProductResult {
    //渠道
    private String channel;
    //PMS酒店代码
    private String hotelCode;
    //房型代码
    private String roomTypeCode;
    //价格代码
    private String ratePlanCode;
    /*
     *创建结果:true 成功；false 失败
     */
    private Boolean isSuccess;
    /*
     * 错误代码
     * 101产品已经存在
     * 102酒店创建失败
     * 103价格代码不存在
     * 104房型创建失败
     * 109其 它错误
     */
    private String code;
    //产品信息返回结果
    private String message;
    public TCSL_VO_ProductResult(){};
    public TCSL_VO_ProductResult(TCSL_XML_PMSHotelMappingResult result){
        this.channel = result.getChannel();
        this.hotelCode = result.getHotelCode();
        this.roomTypeCode = result.getRoomTypeCode();
        this.ratePlanCode = result.getRatePlanCode();
        this.isSuccess = Boolean.parseBoolean(result.getIsSuccess());
        this.code = result.getErrorCode();
        this.message = result.getMessage();
    };

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getHotelCode() {
        return hotelCode;
    }

    public void setHotelCode(String hotelCode) {
        this.hotelCode = hotelCode;
    }

    public String getRoomTypeCode() {
        return roomTypeCode;
    }

    public void setRoomTypeCode(String roomTypeCode) {
        this.roomTypeCode = roomTypeCode;
    }

    public String getRatePlanCode() {
        return ratePlanCode;
    }

    public void setRatePlanCode(String ratePlanCode) {
        this.ratePlanCode = ratePlanCode;
    }

    public Boolean getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Boolean success) {
        this.isSuccess = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
