package com.util;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @DESCRIPTION
 * @AUTHER administrator zhangna
 * @create 2017-05-18
 */
public class TCSL_UTIL_COMMON {
    /**
     * 将list转换成map
     * 说明：将List<v>转换成Map<指定字段拼接字符串，v>
     * @param list 数据源
     * @param fields 拼接key的所有字段名称
     * @return
     */
    public static <String ,v>Map<String,v> mapUtil(List<v> list, List<String> fields){
        Map<String, v> map = new HashMap<String, v>();
        if(fields != null && fields.size() != 0){
            if(list != null && list.size() != 0){
                for (v obj:list) {
                    StringBuilder strBuilder = new StringBuilder();
                    //使用指定属性值拼接key
                    for (String fieldName : fields) {
                        try {
                            PropertyDescriptor propDesc = new PropertyDescriptor((java.lang.String) fieldName, obj.getClass());
                            Method methodGetVal = propDesc.getReadMethod();
                            @SuppressWarnings("unchecked")
                            String keyVal = (String)methodGetVal.invoke(obj);
                            strBuilder.append(keyVal);
                        } catch (IntrospectionException e) {
                            e.printStackTrace();
                        }catch (IllegalAccessException e){
                            e.printStackTrace();
                        }catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    }
                    map.put((String)strBuilder,obj);
                }
            }
        }
        return map;
    }

    /**
     * 检查参数是否为空
     * @param param 参数列表
     * @return 有参数为空true，无参数为空 false
     */
    public static boolean checkParmIsValid(List param){
        if(param != null && param.size() != 0){
            for(Object obj : param){
                if(obj == null || "".equals(obj.toString())){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 在类中读取fileName配置文件中的值,
     * @param fileName 文件名必须是properties为后缀的
     * @return
     */
    public static Properties getProperties(String fileName){
        InputStream inputStream = TCSL_UTIL_COMMON.class.getClassLoader().getResourceAsStream(fileName);
        Properties p = new Properties();
        try {
            p.load(inputStream);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return p;
    }
}
