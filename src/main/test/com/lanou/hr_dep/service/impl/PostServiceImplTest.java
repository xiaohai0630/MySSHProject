package com.lanou.hr_dep.service.impl;

import com.lanou.hr_dep.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/11.
 */
public class PostServiceImplTest {

    private BeanFactory beanFactory;
    private PostService postService;

    @Before
    public void getService(){

        beanFactory = new ClassPathXmlApplicationContext("classpath*:/spring/postContext.xml",
                "classpath*:/spring/applicationContext.xml");

        postService = (PostService) beanFactory.getBean("postService");
    }

    @Test
    public void test(){

        System.out.println(postService.findAllPost());
    }

}
