package com.util;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.apache.commons.httpclient.HttpClient;
import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Properties;

/**
 * @DESCRIPTION 读取SOAP，实现bean与xml间的转换
 * @AUTHER administrator zhangna
 * @create 2017-05-31
 */
public class TCSL_UTIL_XML {
    private static Logger logger = Logger.getLogger(TCSL_UTIL_XML.class);
    /**
     *
     * @param URL soap 请求路径
     * @param soapAction soapAction
     * @param data soap请求数据
     * @return
     */
    public static  String sendSoap(String URL,String soapAction,OMElement data){
       logger.info("start sending soap...");
        Properties p = TCSL_UTIL_COMMON.getProperties("ota.properties");
        long timeOut = Integer.parseInt(p.getProperty("ota_fusing_time")) * 60 * 1000; //程序熔断休息时间(ms)
        int num = Integer.parseInt(p.getProperty("ota_equalize_num")); //配置文件配置补偿次数
        String resultStr = "";
        try {
            //axis2创建一个serviceClient
            ServiceClient serviceClient = new ServiceClient();
            Options option = new Options();
            //设置soapAction
            if(soapAction != null || !"".equals(soapAction)){
                //设置SOAPAction
                option.setAction(soapAction);
            }
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(URL);
            option.setTo(targetEPR);
            option.setExceptionToBeThrownOnSOAPFault(false);
            serviceClient.setOptions(option);
            OMElement result = serviceClient.sendReceive(data);
            //判断soap通信是否成功
            if(result == null || "".equals(result)){ //与OTA通信失败
                logger.info("send soap fail..");
            }else { //与OTA通信成功
                TCSL_UTIL_COMMON.equalizeNum = 0;
                TCSL_UTIL_COMMON.uploadFusingFlag = false;
                resultStr = result.toString();
                logger.info("send soap success..");
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        } finally {
            if(resultStr == null || "".equals(resultStr)){
                sendFailOperate(num,timeOut);
            }
            return resultStr;
        }
    }
    /**
     * 发送soap请求失败操作
     * 1.上传失败 开启补偿
     * 2.上传失败达到熔断次数
     * 2.1 开启熔断标志
     * 2.2 补偿线程休息
     * 2.3 重置补偿次数
     * 3.上传失败没达到熔断次数
     * 3.1补偿线程为空/补偿线程运行结束，新建补偿线程，启动补偿
     * 3.2补偿线程不为空/线程正在运行/线程正在休息 让线程自己处理
     */
    public static void sendFailOperate(int num,long timeOut){
        TCSL_UTIL_COMMON.equalizeNum = TCSL_UTIL_COMMON.equalizeNum + 1; //补偿上传次数加一
        if(num == TCSL_UTIL_COMMON.equalizeNum){ //达到补偿次数上限
            TCSL_UTIL_COMMON.uploadFusingFlag = true; //开启熔断标志
            TCSL_UTIL_COMMON.equalizeNum = 0;
            try {
                TCSL_UTIL_COMMON.rsEqualize.sleep(timeOut); //房态补偿线程休息
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            //房态补偿线程为空/房态补偿线程运行结束
            String rsEqualizeState = TCSL_UTIL_COMMON.rsEqualize.getState().toString();
            if(TCSL_UTIL_COMMON.rsEqualize == null || "TERMINATED".equals(rsEqualizeState)){
                TCSL_UTIL_COMMON.rsEqualize = new TCSL_UTIL_RSEqualize();
                TCSL_UTIL_COMMON.rsEqualize.start();
            }
        }
    }
    /**
     * 将xml转成javabean 忽略命名空间
     * @param cla
     * @param content
     * @param <T>
     * @return
     */
    public static <T> T xmlTojavaBean(Class<T> cla, String content){
        logger.info("xml转javabean start...");
        T t = null;
        JAXBContext jaxbContext = null;
        Unmarshaller unmarshaller = null;
        try {
            jaxbContext = JAXBContext.newInstance(cla);
            unmarshaller = jaxbContext.createUnmarshaller();
            StringReader reader = new StringReader(content);
            SAXParserFactory sax = SAXParserFactory.newInstance();
            //设置忽略命名空间
            sax.setNamespaceAware(false);
            XMLReader xmlReader = sax.newSAXParser().getXMLReader();
            Source source = new SAXSource(xmlReader, new InputSource(reader));
            //将xml转换为需要的java对象的方法
            t= (T)unmarshaller.unmarshal(source);
            logger.info("xml转javabean success...");
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return t;
    }
}
