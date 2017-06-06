package com.util;
import com.rest.TCSL_REST_Hotel;
import com.vo.TCSL_VO_HotelInfo;
import com.xml.PmsHotelInfoRS;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axiom.om.util.AXIOMUtil;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.bind.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.soap.*;
import javax.xml.stream.XMLEventReader;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;
import javax.xml.ws.handler.MessageContext;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

/**
 * @DESCRIPTION 读取SOAP，实现bean与xml间的转换
 * @AUTHER administrator zhangna
 * @create 2017-05-31
 */
public class TCSL_UTIL_XMLData {
    private static Logger logger = Logger.getLogger(TCSL_UTIL_XMLData.class);
    /**
     * 发送soap请求，获得soap响应
     * @param URL  接口地址
     * @param action  SOAPAction
     * @param nameSpace 参数xml的命名空间
     * @param actionParam 开始标签名
     * @param op  第二级标签名
     * @param param
     * @return
     */
    public static  String getSoapXMLResponse(String URL,String action,String nameSpace,String actionParam,String op,String param){
       logger.info("start sending soap...");
        String resultStr = null;
        try {
            //axis2创建一个serviceClient
            RPCServiceClient serviceClient = new RPCServiceClient();
            Options option = new Options();
            //设置SOAPAction
            option.setAction(action);
            // 指定调用WebService的URL
            EndpointReference targetEPR = new EndpointReference(URL);
            option.setTo(targetEPR);
            serviceClient.setOptions(option);
            //创建response SOAP包。
            OMFactory factory = OMAbstractFactory.getOMFactory();
            // OMNamespace指定此SOAP文档名称空间。
            OMNamespace omNamespace = factory.createOMNamespace(nameSpace,"");
            //创建OMElement元素 将omNamespace作为命名空间
           /* OMElement data = factory.createOMElement(actionParam,omNamespace);
            OMElement inner = factory.createOMElement(op,omNamespace);
            inner.setText(param);
            data.addChild(inner);*/
            OMElement data = factory.createOMElement(param,omNamespace);
            //发送数据返回结果
            OMElement result = serviceClient.sendReceive(data);
            //StringEscapeUtils.unescapeXml用于转换为xml格式的字符串
            //resultStr = StringEscapeUtils.unescapeXml(result.getFirstElement().getText());
            resultStr = result.toString();
            logger.info("send soap success..");
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return resultStr;
    }

    /**
     * 将javabean类型转为xml类型string
     * @param obj
     * @return
     * @throws Exception
     */
    public static String beanToString(Object obj){
        logger.info("javabean转xml start...");
        String xmlString = null;
        if(obj == null){
            xmlString="";
        }
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            marshaller.marshal(obj, sw);
            xmlString = sw.toString();
            logger.info("javabean转xml success...");
        } catch (JAXBException e){
//            throw new Exception("obj"+obj+"to string exception",e);
            e.printStackTrace();
        }
        return xmlString;
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
