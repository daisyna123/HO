package com.bo;

import com.dao.TCSL_DAO_Test;
import com.po.TCSL_PO_Test;
import com.vo.TCSL_VO_Result;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangtuoyu on 2017/4/27.
 */
@Repository
public class TCSL_BO_Test {
    @Resource
    TCSL_DAO_Test tcslDaoTest;
    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)
    public TCSL_VO_Result aaa(){
        System.out.println("非事务管理方法");
        TCSL_VO_Result result = new TCSL_VO_Result();
        List<TCSL_PO_Test> list = ccc();
        result.setData(list);
        return result;
    }
    public List<TCSL_PO_Test> ccc(){
        List<TCSL_PO_Test> list = bbb();
        return list ;
    }
    public List<TCSL_PO_Test> bbb(){
        TCSL_PO_Test xiaobai = new TCSL_PO_Test();
        xiaobai.setNAME("小白");
        xiaobai.setADDRESS("鞍山西道");
        xiaobai.setAGE(12);
        //插入第一条数据
        tcslDaoTest.save(xiaobai);
        TCSL_PO_Test bai = new TCSL_PO_Test();
        bai.setNAME("一坨羊毛");
        bai.setADDRESS("山羊村");
        bai.setAGE(11);
        //插入第二条数据
        tcslDaoTest.save(bai);
        List<TCSL_PO_Test> list = tcslDaoTest.getAll();
        return list;
    }

}
