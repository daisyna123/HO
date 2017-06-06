package com.vo;

/**
 *  @DESCRIPTION 响应参数列表
 * Created by zhangtuoyu on 2017/4/27.
 */
public class TCSL_VO_Result {

   private String errorCode;
   private String errorText;
   /*
    * 1:成功
    * -1：失败
    */
   private int returnCode;
   //数据json
   private Object data;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
