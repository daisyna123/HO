package com.bo;
import com.dao.TCSL_DAO_Test;
import com.po.TCSL_PO_Test;
import com.util.TCSL_UTIL_COMMON;
import com.util.TCSL_UTIL_XMLData;
import com.vo.TCSL_VO_HotelInfo;
import com.vo.TCSL_VO_Result;
import com.xml.PmsHotelInfoRS;
import com.xml.Translator;
import org.apache.commons.httpclient.HttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-redis.xml"})
public class TCSL_BO_Test1 {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TCSL_DAO_Test tcslDaoTest;

    @Test
    public void testRedis(){
        ValueOperations<String, Object> vOps = redisTemplate.opsForValue();
        System.out.println(vOps);
        if(vOps == null){
            System.out.println("时空");
        }
        vOps.set("zn",56);
        System.out.println( vOps.get("zn"));
    }
    /*@Test
    public void testStr(){
        redisPool.set("lisi","123");
        System.out.println(redisPool.getStr("lisi"));
        redisPool.del("lisi");
        System.out.println(redisPool.getStr("lisi"));
    }*/

    /**
     * 测试soap请求
     */
    @Test
    public void testXMLsoap() {
        String soapData="<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:web=\"http://WebXml.com.cn/\">\n" +
                "<soap:Header>\n" +
                "</soap:Header>\n" +
                "<soap:Body>\n" +
                "   <web:Translator>\n" +
                "         <!--Optional:-->\n" +
                "         <web:wordKey>翻译</web:wordKey>\n" +
                "      </web:Translator>\n" +
                "</soap:Body>\n" +
                "</soap:Envelope>";
        System.out.println("soapData-----------------"+soapData);
        PostMethod postMethod = new PostMethod("http://fy.webxml.com.cn/webservices/EnglishChinese.asmx");
        byte[] b = new byte[0];
        try {
           //b = soapRequestData.getBytes("utf-8");
            b = soapData.getBytes("utf-8");
            //ByteArrayInputStream 类从内存中的字节数组中读取数据，因此它的数据源是一个字节数组。
            InputStream is = new ByteArrayInputStream(b,0,b.length);
            RequestEntity re = new InputStreamRequestEntity(is,b.length,"application/soap+xml;charset=utf-8");
            postMethod.setRequestEntity(re);
            HttpClient httpClient = new HttpClient();
            int statusCode = 0;
            statusCode = httpClient.executeMethod(postMethod);
            System.out.println("statusCode====="+statusCode);
            //返回xml格式数据
            soapData =  postMethod.getResponseBodyAsString();
            //返回xml格式数据
            byte[] responseBody = postMethod.getResponseBody();
            //处理内容
            System.out.println("responseBody------"+new String(responseBody));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("返回的结果：------------------"+soapData);
        // 调用请求END
    }
    /**
     * 测试javabean转为soap类型xml
     */
    @Test
    public void testxml(){
        TCSL_VO_Result dsfd = new TCSL_VO_Result();

        //测试bean转xml
       /* TCSL_VO_HotelInfo info = new TCSL_VO_HotelInfo();
        info.setAddress("天津");
        info.setEmail("123@qq.com");
        info.setHotelName("天财商龙");
        String param = TCSL_UTIL_XMLData.beanToString(info);
        System.out.println(param);*/
        Translator translator = new Translator();
        translator.setWordKey("name");
        String param = TCSL_UTIL_XMLData.beanToString(translator);
        //测试结束
        String url = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx";
        String action = "http://WebXml.com.cn/Translator";
        String nameSpace = "http://www.opentravel.org/OTA/2003/05";
       // String param = "name";
        String actionParam = "PmsHotelInfoRQ";
        String op = "PMSBaseHotelInfos";
        String result = TCSL_UTIL_XMLData.getSoapXMLResponse(url, action, nameSpace,actionParam,op,param);
            System.out.println("result=================="+result);
            //测试soap响应xml取body转换成bean
        /*String result ="<PmsHotelInfoRS xmlns=\"http://www.opentravel.org/OTA/2003/05\">\n" +
                "         <PMSHotelMappingResults>\n" +
                "            <PMSHotelMappingResult>\n" +
                "               <HotelCode>?</HotelCode>\n" +
                "               <IsSuccess>false</IsSuccess>\n" +
                "               <ErrorCode>109</ErrorCode>\n" +
                "               <Message>参数有误，酒店组代码不存在;</Message>\n" +
                "            </PMSHotelMappingResult>\n" +
                "            <PMSHotelMappingResult>\n" +
                "               <HotelCode>?</HotelCode>\n" +
                "               <IsSuccess>false</IsSuccess>\n" +
                "               <ErrorCode>109</ErrorCode>\n" +
                "               <Message>未获取到需要创建的酒店产品;</Message>\n" +
                "            </PMSHotelMappingResult>\n" +
                "         </PMSHotelMappingResults>\n" +
                "      </PmsHotelInfoRS>\n";
        //PmsHotelInfoRS responce = TCSL_UTIL_XMLData.converyToJavaBean(result, PmsHotelInfoRS.class);
        PmsHotelInfoRS responce = TCSL_UTIL_XMLData.xmlTojavaBean(PmsHotelInfoRS.class,result);
        System.out.println(responce.getPmsHotelMappingResults().getPmsHotelMappingResultList().get(0).getMessage());
        System.out.println(responce.getPmsHotelMappingResults().getPmsHotelMappingResultList().get(0).getErrorCode());*/
    }

    /**
     * 测试在Java中读取properties配置文件中的值
     */
    @Test
    public void testReadpropeties(){
     /*   InputStream inputStream = TCSL_BO_Test1.class.getClassLoader().getResourceAsStream("ota.properties");
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }*/
//        调用工具类TCSL_UTIL_COMMON.getproperties()方法读取ota.properties配置文件中的url，nameSpace，soapAction的值
        Properties p = TCSL_UTIL_COMMON.getProperties("ota.properties");
        System.out.println("url:"+p.getProperty("ota_uploadHotelInfo_url")+",soapAction:"+p.getProperty("ota_uploadHotelInfo_soapAction"));
    }
}
