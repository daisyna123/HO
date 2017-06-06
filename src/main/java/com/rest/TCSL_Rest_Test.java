package com.rest;

import com.bo.TCSL_BO_Test;
import com.dao.TCSL_DAO_Test;
import com.mq.TCSL_MQ_MessageProducer;
import com.po.TCSL_PO_Test;
import com.redis.RedisUtil;
import com.vo.TCSL_VO_Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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

    @Autowired
    private TCSL_BO_Test tcslDaoTest;

    @Resource
    private RedisUtil redisUtil;
    @Resource
    private TCSL_MQ_MessageProducer messageProducer;

    @RequestMapping("testList")
    @ResponseBody
    public Set  testList(){
//        TCSL_VO_Result result = new TCSL_VO_Result();
//        result.setContent("你好");
//        return result;
        //清空指定key 所有内容
        redisUtil.delCache("testMap");
        Object[] values = {"value1","value2","value3"};
        redisUtil.addCacheSet("testMap",values);
        //查询缓存中内容
        Set set = redisUtil.getCacheSet("testMap");
        System.out.println("缓存中内容"+set);

        Map map = new HashMap();
        map.put("value3","{name:'json内容'}");
        redisUtil.modifyCacheSet("testMap",map);
        Set newSet = redisUtil.getCacheSet("testMap");
        System.out.println("缓存中修改后的内容"+newSet);

        Object[] vals = {"value1"};
        redisUtil.delCacheSet("testMap",vals);
        Set set2 = redisUtil.getCacheSet("testMap");
        System.out.println("缓存中删除后的内容"+set2);
        return set2;
    }
   /* @RequestMapping("testSendMsg")
    @ResponseBody
    public TCSL_VO_Result testSendMessage(){
        TCSL_VO_Result result = new TCSL_VO_Result();
        result.setRet(0);
        result.setContent("发送成功");
        JSONObject json = JSONObject.fromObject(result);
        messageProducer.sendMessage(json);
        return result;
    }*/
    @RequestMapping("/test")
    @ResponseBody
    public TCSL_VO_Result test(){
        TCSL_PO_Test xiaobai = new TCSL_PO_Test();
        xiaobai.setNAME("小白");
        xiaobai.setADDRESS("鞍山西道");
        xiaobai.setAGE(12);
        //插入第一条数据
        tcslBoTest.save(xiaobai);
        TCSL_PO_Test bai = new TCSL_PO_Test();
        bai.setNAME("一坨羊毛");
        bai.setADDRESS("山羊村");
        bai.setAGE(12);
        //插入第二条数据
        tcslBoTest.save(bai);
        //throw new RuntimeException("kdjf");
        List<TCSL_PO_Test> list = tcslBoTest.getUser();
       TCSL_VO_Result result = new TCSL_VO_Result();
       result.setData(list);
       return result;
   }
}
