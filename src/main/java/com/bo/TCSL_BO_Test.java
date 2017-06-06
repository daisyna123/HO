package com.bo;

import com.dao.TCSL_DAO_Test;
import com.po.TCSL_PO_Test;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@Repository
@Transactional(readOnly = true)
public class TCSL_BO_Test {
    @Resource
    TCSL_DAO_Test tcslDaoTest;

    public List<TCSL_PO_Test> getUser(){
        List<TCSL_PO_Test> users = tcslDaoTest.getAll();
        return users;
    }
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void save(TCSL_PO_Test tcslPoTest){
        tcslDaoTest.save(tcslPoTest);
    }
}
