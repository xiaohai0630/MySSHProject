package com.lanou.utils;

import com.lanou.hr_dep.domain.Staff;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by dllo on 17/11/10.
 */
public class MyInterceptor extends MethodFilterInterceptor {
    // 拦截器
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession();
        Staff staff = (Staff) session.getAttribute("nowStaff");

        // 如果没有登录，跳转到登录界面
        if (staff == null){
            return "interceptors";
        }

        return actionInvocation.invoke();
    }

}
