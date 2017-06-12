package com.util;

/**
 * @DESCRIPTION 定义工程中常量
 * @AUTHER administrator zhangna
 * @create 2017-05-19
 */
public class TCSL_UTIL_RESOURCE {

    /**
     * 错误代码套系
     */
    public static final String RESOURCE_ERROR_CODE_SUCCESS = "200"; //成功
    public static final String RESOURCE_ERROR_DES_SUCCESS = "成功";

    public static final String RESOURCE_ERROR_CODE_INVALIDPARAM = "400";    //参数不全
    public static final String RESOURCE_ERROR_DES_INVALIDPARAM = "参数不全";

    public static final String RESOURCE_ERROR_CODE_OTA = "401";    //上传OTA失败
    public static final String RESOURCE_ERROR_DES_OTA = "上传OTA失败";

    public static final String RESOURCE_ERROR_CODE_SYSTEM = "500";  //系统错误
    public static final String RESOURCE_ERROR_DES_SYSTEM = "系统错误";

    public static final String RESOURCE_ERROR_CODE_PRODUCTFAIL = "501"; //产品创建失败
    public static final String RESOURCE_ERROR_DES_PRODUCTFAIL = "产品创建失败";

    public static final String RESOURCE_ERROR_CODE_OTAFAIL = "502"; //OTA服务异常
    public static final String RESOURCE_ERROR_DES_OTAFAIL = "OTA服务异常，请稍候重试"; //OTA服务异常

    public static final int RESOURCE_RETRUN_CODE_SUCCESS = 1; //处理成功
    public static final int RESOURCE_RETRUN_CODE_FAIL = -1; //处理失败


}
