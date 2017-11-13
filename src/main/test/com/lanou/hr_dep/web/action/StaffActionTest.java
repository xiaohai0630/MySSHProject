package com.lanou.hr_dep.web.action;

import com.lanou.hr_dep.dao.StaffDao;
import com.lanou.hr_dep.service.StaffService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/13.
 */
public class StaffActionTest {

    private BeanFactory beanFactory;
    private StaffService staffService;

    @Before
    public void init() {
        beanFactory = new ClassPathXmlApplicationContext("classpath*:/spring/staffContext.xml",
                "classpath:/spring/applicationContext.xml");

        staffService = (StaffService) beanFactory.getBean("staffService");
    }

    @Test
    public void testFindAll(){
        System.out.println(staffService.findAllStaff());
    }

}
