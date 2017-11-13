package com.lanou.hr_dep.web.action;

import com.lanou.hr_dep.domain.Post;
import com.lanou.hr_dep.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dllo on 17/11/13.
 */
public class PostActionTest {

    private BeanFactory beanFactory;
    private PostService postService;

    @Before
    public void init() {

        beanFactory = new ClassPathXmlApplicationContext("classpath*:/spring/postContext.xml",
                "classpath*:/spring/applicationContext.xml");

        postService = (PostService) beanFactory.getBean("postService");
    }

    @Test
    public void testAdd(){

        Post post = new Post();
        post.setPostName("测试");

        postService.addOrEditPost(post);
    }

}
