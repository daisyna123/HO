package com.bo;

import com.dao.TCSL_DAO_Test;
import com.vo.TCSL_VO_Test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-redis.xml"})
public class TCSL_BO_Test {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testRedis(){
        ValueOperations<String, Object> vOps = redisTemplate.opsForValue();
        System.out.println(vOps);
        if(vOps == null){
            System.out.println("时空");
        }
        vOps.set("123","456");
    }
}
