package com.bo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
        vOps.set("zn",56);
        System.out.println( vOps.get("zn"));
    }
    /*@Test
    public void testStr(){
        redisPool.set("lisi","123");
        System.out.println(redisPool.getStr("lisi"));
        redisPool.del("lisi");
        System.out.println(redisPool.getStr("lisi"));
    }*/
}
