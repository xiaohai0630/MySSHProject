package com.lanou.hr_dep.dao.impl;

import com.lanou.hr_dep.dao.StaffDao;
import com.lanou.hr_dep.domain.Staff;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by dllo on 17/11/11.
 */
public class StaffDaoImplTest {

    private BeanFactory beanFactory;
    private StaffDao staffDao;

    @Before
    public void getDao() {
        beanFactory = new ClassPathXmlApplicationContext("/spring/staffContext.xml",
                "/spring/applicationContext.xml");

        staffDao = (StaffDao) beanFactory.getBean("staffDao");
    }

    // 查询全部的职员
    @Test
    public void testDao() {
        System.out.println(staffDao.findAll());
    }

    // 查询某个部门下的职员
    @Test
    public void testDep() {
        System.out.println(staffDao.findAll("and postID in (select postID from Post where depID = ?)", 1));
    }
}
