package com.webService;

import org.springframework.stereotype.Repository;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/6/21.
 */

@Repository("helloWorld")
@WebService(serviceName = "hello")
@SOAPBinding(style = Style.DOCUMENT)
public class TCSL_HelloWorld{

    @WebMethod
    public String sayHi(
            @WebParam(name = "cityName") String cityName) {
        return "cityName is :" + cityName ;
    }

    @WebMethod(operationName = "getUser")
    @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
    public @WebResult(name = "User") User getUser() {
        User user = new User();
        user.setName("张三");
        return user;
    }

    @WebMethod()
    public @WebResult(name = "Users") List<User> getUsers(){
        List<User> users = new ArrayList<User>();
        chinese chi = new chinese("中国人");
        ArrayList<chinese> list = new ArrayList<chinese>();
        list.add(chi);
        UserAtt userAtt = new UserAtt("天津","煎饼果子");
        User user1 = new User("李四","天津","男",userAtt,list);
        User user2 = new User("张三","天津","男",userAtt,list);
        users.add(user1);
        users.add(user2);
        return users;
    }

    @WebMethod
    @WebResult(name = "Users")
    public List<User> getUsersParam(@WebParam(name = "User") User user){
        List<User> users = new ArrayList<User>();
        users.add(user);
        users.add(user);
        return users;
    }
}
