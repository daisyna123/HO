package com.rest;

import com.bo.TCSL_BO_Test;
import com.vo.TCSL_VO_Result;
import com.vo.TCSL_VO_Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@Controller
@RequestMapping("/test")
public class TCSL_Rest_Test{
    @Resource
    TCSL_BO_Test tcslBoTest;

    @RequestMapping("helloWorld")
    @ResponseBody
    public String HelloWorld(){
        return "Hello World!!!!";
    }
    @RequestMapping("getUsers")
    @ResponseBody
    public List<TCSL_VO_Test> getUsers(){
        List<TCSL_VO_Test> users = tcslBoTest.getUser();
//        TCSL_VO_Result result = new TCSL_VO_Result();
//        result.setRet(0);
//        result.setContent(users);
        return users;
    }
}
