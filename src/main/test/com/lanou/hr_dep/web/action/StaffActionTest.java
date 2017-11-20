package com.lanou.hr_dep.web.action;

import com.lanou.hr_dep.domain.Staff;
import com.lanou.hr_dep.service.StaffService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    @Test
    public void testDate() throws ParseException {
        List<Staff> allStaff = staffService.findAllStaff();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("日期1: " + format.parse("2016-10-24"));

        System.out.println("日期2：" + format.format(allStaff.get(0).getOnDutyDate()).getClass());

        System.out.println("日期3：" + allStaff.get(0).getOnDutyDate());
    }

}
