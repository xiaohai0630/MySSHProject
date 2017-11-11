package com.lanou.hr_dep.dao.impl;

import com.lanou.hr_dep.dao.DepartmentDao;
import com.lanou.hr_dep.domain.Department;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/10.
 */
public class DepartmentDaoImplTest{

    /**
     * 测试了一下dao层
     * 可以执行查询全部的方法
     * 把对应的spring配置文件和总的配置文件都引入就可以了
     */

    private BeanFactory beanFactory;
    private DepartmentDao departmentDao;

    @Before
    public void getDao(){
        beanFactory = new ClassPathXmlApplicationContext("/spring/depContext.xml",
                "/spring/applicationContext.xml");

        departmentDao = (DepartmentDao) beanFactory.getBean("depDao");
    }

    @Test
    public void testDao(){

        System.out.println(departmentDao.findAll());
    }

    @Test
    public void testDaoAdd(){

        Department department = new Department();
        department.setDepName("测试");
        departmentDao.saveOrUpdate(department);
    }

    @Test
    public void testDaoEdit(){
        Department department = new Department();
        department.setDepID(20);
        department.setDepName("2222");
        departmentDao.saveOrUpdate(department);
    }

}
