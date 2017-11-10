package com.lanou.hr_dep.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/10.
 */
@ContextConfiguration({"classpath*:/spring/depContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DepartmentDaoImplTest{

    @Resource
    private DepartmentDaoImpl departmentDao;

    @Test
    public void testShowAll(){

        System.out.println("显示全部部门信息： " + departmentDao.findAll());
    }

}
