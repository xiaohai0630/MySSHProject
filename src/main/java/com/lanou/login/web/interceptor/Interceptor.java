package com.lanou.login.web.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Created by dllo on 17/11/10.
 */
public class Interceptor extends AbstractInterceptor {
    // 拦截器？
    public String intercept(ActionInvocation actionInvocation) throws Exception {

        String result = actionInvocation.invoke();

        return null;
    }

}
