package com.util;
import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.om.OMNamespace;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.commons.lang.StringEscapeUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @DESCRIPTION 读取SOAP，实现bean与xml间的转换
 * @AUTHER administrator zhangna
 * @create 2017-05-31
 */
public class TCSL_UTIL_XMLData {
    /**
     * 发送soap请求
     * @param URL  接口地址
     * @param action  SOAPAction
     * @param nameSpace 参数xml的命名空间
     * @param actionParam
     * @param op
     * @param param
     * @return
     */
    public static  String getSoapXMLResponse(String URL,String action,String nameSpace,String actionParam,String op,String param){
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
            OMElement data = factory.createOMElement(actionParam,omNamespace);
            OMElement inner = factory.createOMElement(op,omNamespace);
            inner.setText(param);
            data.addChild(inner);
            //发送数据返回结果
            OMElement result = serviceClient.sendReceive(data);
            //StringEscapeUtils.unescapeXml用于转换为xml格式的字符串
            //resultStr = StringEscapeUtils.unescapeXml(result.getFirstElement().getText());
            resultStr = result.toString();
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
        } catch (JAXBException e){
//            throw new Exception("obj"+obj+"to string exception",e);
            e.printStackTrace();
        }
        return xmlString;
    }

    /**
     * 将xml转换为javabean
     * @param xml
     * @param c
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T converyToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            t = (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return t;
    }
}
