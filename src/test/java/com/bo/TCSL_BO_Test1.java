package com.bo;
import com.util.TCSL_UTIL_COMMON;
import com.util.TCSL_UTIL_XML;
import com.vo.TCSL_VO_Result;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.impl.OMElementEx;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.MessageContext;
import org.apache.commons.httpclient.HttpClient;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.Properties;

import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-redis.xml"})
public class TCSL_BO_Test1 {

    @Autowired
    private RedisTemplate redisTemplate;


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
       /* // 1.创建httpClient客户端
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // 2.获取http post
        HttpPost httppost = new HttpPost("http://fy.webxml.com.cn/webservices/EnglishChinese.asmx");
        // 3.设置发送请求的字符集编码
       // httppost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=" + "utf-8");
          // 4.把SOAP请求数据添加到http post方法中,此方式也可实现，处理方式可能有点绕
        byte[] by = new byte[0];
        try {
            by = soapData.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InputStream inputStream = new ByteArrayInputStream(by, 0, by.length);
        //实例化输入流请求实体:使用HttpClient测试Soap接口比较特殊;服务端可能是以IO流的形式接收数据的，此处先作此定论，后续再做研究
        InputStreamEntity reqEntity = new InputStreamEntity(inputStream,by.length);
        //设置http请求实体,将请求的String数据转换成StringEntity实体，一定要指定字符集编码
        //StringEntity reqEntity = new StringEntity(soapData,"utf-8");
        httppost.setEntity(reqEntity);
        // 5.执行http post请求
        HttpResponse response = null;
        try {
            response = httpclient.execute(httppost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 6.获取服务端返回的状态码
        int statuscode = response.getStatusLine().getStatusCode();
        // 7.获取服务器的返回实体
        HttpEntity entity = response.getEntity();
        String responseMsg = null;
        try {
            responseMsg = EntityUtils.toString(entity);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("返回的状态码与响应结果:" + statuscode + ":" + responseMsg);*/
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
//        Translator translator = new Translator();
//        translator.setWordKey("name");
//        String param = TCSL_UTIL_XML.beanToString(translator);
        //测试结束
        String url = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx";
        String action = "http://WebXml.com.cn/Translator";
        String nameSpace = "http://www.opentravel.org/OTA/2003/05";
       // String param = "name";
        String actionParam = "PmsHotelInfoRQ";
        String op = "PMSBaseHotelInfos";
//        String result = TCSL_UTIL_XMLData.getSoapXMLResponse(url, action, nameSpace,actionParam,op,param);
//            System.out.println("result=================="+result);
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
    @Test
    public void testBeanToXml(){
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace webNamespace = factory.createOMNamespace("http://WebXml.com.cn/","web");
        OMElement transTag = factory.createOMElement("Translator",webNamespace);
        OMElement wordKeyTag = factory.createOMElement("wordKey",webNamespace);
        wordKeyTag.setText("name");
        transTag.addChild(wordKeyTag);
        System.out.println("请求参数------"+transTag);
        String url = "http://fy.webxml.com.cn/webservices/EnglishChinese.asmx";
        String soapAction = "http://WebXml.com.cn/Translator";
        TCSL_UTIL_XML.sendSoap(url,soapAction,transTag);
    }

    /**
     * 测试soap请求
     * <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" >
     <soapenv:Header/>
     <soapenv:Body>
     <web:Translator xmlns:web="http://WebXml.com.cn/">
     <web:wordKey>#7￥</web:wordKey></web:Translator>
     </soapenv:Body>
     </soapenv:Envelope>

     */
    @Test
    public void testUtilXmlSoap(){
        OMFactory factory = OMAbstractFactory.getOMFactory();
        OMNamespace namespaceWeb= factory.createOMNamespace("http://WebXml.com.cn/","web");
        OMElement Translator = factory.createOMElement("Translator",namespaceWeb);
        OMElement wordKey = factory.createOMElement("wordKey",null);
        wordKey.setText("name");
        Translator.addChild(wordKey);
        String result= TCSL_UTIL_XML.sendSoap("http://fy.webxml.com.cn/webservices/EnglishChinese.asmx",
                "http://WebXml.com.cn/Translator",Translator);
        System.out.println("发送soap请求结果------------"+result);
    }
}
