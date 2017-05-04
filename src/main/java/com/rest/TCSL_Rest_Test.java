package com.rest;

import com.bo.TCSL_BO_Test;
import com.redis.RedisUtil;
import com.vo.TCSL_VO_Result;
import com.vo.TCSL_VO_Test;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

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

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("testList")
    @ResponseBody
    public TCSL_VO_Result  testList(){
        TCSL_VO_Result result = new TCSL_VO_Result();
        result.setContent("你好");
        return result;
//        //清空指定key 所有内容
//        redisUtil.delCache("testMap");
//        Object[] values = {"value1","value2","value3"};
//        redisUtil.addCacheSet("testMap",values);
//        //查询缓存中内容
//        Set set = redisUtil.getCacheSet("testMap");
//        System.out.println("缓存中内容"+set);
//
//        Map map = new HashMap();
//        map.put("value3","修改内容1");
//        redisUtil.modifyCacheSet("testMap",map);
//        Set newSet = redisUtil.getCacheSet("testMap");
//        System.out.println("缓存中修改后的内容"+newSet);
//
//        Object[] vals = {"value1"};
//        redisUtil.delCacheSet("testMap",vals);
//        Set set2 = redisUtil.getCacheSet("testMap");
//        System.out.println("缓存中删除后的内容"+set2);

    }
}
