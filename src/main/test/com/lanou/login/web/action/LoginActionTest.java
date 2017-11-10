package com.lanou.login.web.action;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by dllo on 17/11/10.
 */
@ContextConfiguration({"classpath*:/spring/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class LoginActionTest {

    @Resource
    private LoginAction loginAction;

    @Test
    public void testLogin(){

        System.out.println(loginAction.login());
    }

}
