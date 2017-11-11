package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.service.StaffService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by dllo on 17/11/11.
 */
public class StaffServiceImplTest {

    private BeanFactory beanFactory;
    private StaffService staffService;

    @Before
    public void getService(){

        beanFactory = new ClassPathXmlApplicationContext("/spring/staffContext.xml",
                "/spring/applicationContext.xml");

        staffService = (StaffService) beanFactory.getBean("staffService");
    }

    @Test
    public void testService(){

        System.out.println(staffService.findAllStaff());
    }

}
