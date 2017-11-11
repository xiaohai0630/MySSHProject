package com.lanou.hr_dep.web.action;

import com.lanou.hr_dep.service.DepartmentService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/11.
 */
public class DepartmentActionTest {

    /**
     * action和service之间应该也是没有问题了
     */
    
    private BeanFactory beanFactory;
    private DepartmentService departmentService;

    @Before
    public void getDao(){
        beanFactory = new ClassPathXmlApplicationContext("/spring/depContext.xml",
                "/spring/applicationContext.xml");

        departmentService = (DepartmentService) beanFactory.getBean("depService");
    }

    @Test
    public void testDao(){

        System.out.println(departmentService.findAllDep());
    }

}
