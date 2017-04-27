package com.bo;

import com.dao.TCSL_DAO_Test;
import com.vo.TCSL_VO_Test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class TCSL_BO_Test {
    @Resource
    TCSL_DAO_Test tcslDaoTest;

    @Test
    public void getUser(){
        List<TCSL_VO_Test> users = tcslDaoTest.getAll();
        JSONArray jsonUsers = JSONArray.fromObject(users);
        System.out.println(jsonUsers);
    }
}
