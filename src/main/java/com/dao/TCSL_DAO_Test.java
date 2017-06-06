package com.dao;

import com.po.TCSL_PO_Test;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
public interface TCSL_DAO_Test {

    //查询测试表o2o_test所有数据
    public List<TCSL_PO_Test> getAll();

    //插入数据到测试表o2o_test
    public void save(TCSL_PO_Test tcslPoTest);
}
