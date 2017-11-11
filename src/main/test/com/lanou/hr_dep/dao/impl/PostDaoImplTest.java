package com.lanou.hr_dep.dao.impl;

import com.lanou.hr_dep.dao.PostDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/11.
 */
public class PostDaoImplTest {

    private BeanFactory beanFactory;
    private PostDao postDao;

    @Before
    public void getDao(){

        beanFactory = new ClassPathXmlApplicationContext("classpath*:/spring/postContext.xml",
                "classpath*:/spring/applicationContext.xml");

        postDao = (PostDao) beanFactory.getBean("postDao");
    }

    @Test
    public void testDao(){
        System.out.println(postDao.findAll());
    }

}
