package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

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

    // 模糊查询
    @Test
    public void testSql(){
        List<Staff> a = staffService.findStaffWithMsgName("a");
        System.out.println(a);
    }

    @Test
    public void testIn(){
        List<Staff> staffList = staffService.findStaffWithMsgDepAndName(1, "a");
        System.out.println(staffList);
    }

}
