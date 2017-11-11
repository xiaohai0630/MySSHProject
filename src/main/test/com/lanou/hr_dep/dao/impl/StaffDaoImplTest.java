package com.lanou.hr_dep.dao.impl;

import com.lanou.hr_dep.dao.StaffDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/11.
 */
public class StaffDaoImplTest {

    private BeanFactory beanFactory;
    private StaffDao staffDao;

    @Before
    public void getDao(){
        beanFactory = new ClassPathXmlApplicationContext("/spring/staffContext.xml",
                "/spring/applicationContext.xml");

        staffDao = (StaffDao) beanFactory.getBean("staffDao");
    }

    // 查询全部的职务
    @Test
    public void testDao(){
        System.out.println(staffDao.findAll());
    }

}
