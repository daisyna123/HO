package com.util;
import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import java.io.StringReader;

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
        String resultStr = null;
        try {
            //axis2创建一个serviceClient
            ServiceClient serviceClient = new ServiceClient();
            Options option = new Options();
            //设置SOAPAction
            option.setAction(soapAction);
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(URL);
            option.setTo(targetEPR);
            serviceClient.setOptions(option);
            OMElement result = serviceClient.sendReceive(data);
            resultStr = result.toString();
            logger.info("send soap success..");
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return resultStr;
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
