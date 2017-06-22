package com.webService;


import com.xml.TCSL_PARAM_AddOrder_OTA_HotelResRQ;
import org.springframework.stereotype.Repository;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by zhangtuoyu on 2017/6/22.
 */
@Repository("tcsl_ws_addOrder")
@WebService(serviceName = "addOrder")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class TCSL_WS_AddOrder {

    @WebMethod
    @WebResult(name = "OTA_HotelResRQ")
    public TCSL_PARAM_AddOrder_OTA_HotelResRQ addOrder(@WebParam(name = "OTA_HotelResRQ") TCSL_PARAM_AddOrder_OTA_HotelResRQ param){
        return param;
    }

}
