package com.rest;

import com.bo.TCSL_BO_Test;
import com.vo.TCSL_VO_Result;
import com.vo.TCSL_VO_Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
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
    @Resource(name = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("helloWorld")
    @ResponseBody
    public String HelloWorld(){
        return "Hello World!!!!";
    }

    @RequestMapping("getUsers")
    @ResponseBody
    public List<TCSL_VO_Test> getUsers(){
        List<TCSL_VO_Test> users = tcslBoTest.getUser();
        return users;
    }

    @RequestMapping("redis")
    @ResponseBody
    public String testRedis(){
        ValueOperations<String,Object> ops =redisTemplate.opsForValue();
        ops.set("123","321");
        return "缓存成功";
    }
}
