package com.webService;


import javax.ws.rs.FormParam;

/**
 * Created by zhangtuoyu on 2017/6/19.
 */
public class HelloWorldImpl implements HelloWorld {

    public String sayHello(@FormParam("msg") String msg) {
        return "success";
    }
}
