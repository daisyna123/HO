package com.util;

/**
 * @DESCRIPTION 定义工程中常量
 * @AUTHER administrator zhangna
 * @create 2017-05-19
 */
public class TCSL_UTIL_RESOURCE {
    /**
     * 返回值错误列表
     */
    public static final String RESOURCE_ERROR_CODE_SUCCESS = "200"; //errorCode成功代码
    public static final String RESOURCE_ERROR_CODE_INVALIDPARAM = "400";    //errorCode参数不全代码
    public static final String RESOURCE_ERROR_CODE_AUTH = "401";    //errorCode认证失败代码
    public static final String RESOURCE_ERROR_CODE_SYSTEM = "500";  //errorCode系统错误代码
    public static final String RESOURCE_ERROR_CODE_PRODUCTEXISTS = "501";//产品已经存在
    public static final String RESOURCE_ERROR_CODE_PRODUCTFAIL = "502"; //产品创建失败
    public static final String RESOURCE_ERROR_DES_PRODUCTFAIL = "产品创建失败";

    public static final String RESOURCE_ERROR_DES_SUCCESS = "成功";   //errorText
    public static final String RESOURCE_ERROR_DES_INVALIDPARAM = "参数不全";    //errorText
    public static final String RESOURCE_ERROR_DES_AUTH = "认证失败";        //errorText
    public static final String RESOURCE_ERROR_DES_SYSTEM = "系统错误";      //errorText
    public static final String RESOURCE_ERROR_DES_PRODUCTEXISTS = "产品已经存在";//errorText
    public static final int RESOURCE_RETRUN_CODE_SUCCESS = 1;  //returnCode成功标识
    public static final int RESOURCE_RETRUN_CODE_FAIL = -1;  //returnCode失败标识


}
