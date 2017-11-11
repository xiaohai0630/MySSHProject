package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/11.
 */
public class DepartmentServiceImplTest {

    /**
     * 测试了一下查询全部，可以从数据库中查询结果
     */

    private BeanFactory beanFactory;
    private DepartmentService departmentService;

    @Before
    public void getService(){

        beanFactory = new ClassPathXmlApplicationContext("/spring/depContext.xml",
                "/spring/applicationContext.xml");

        departmentService = (DepartmentService) beanFactory.getBean("depService");
    }

    @Test
    public void testService(){

        System.out.println(departmentService.findAllDep());
    }

}
